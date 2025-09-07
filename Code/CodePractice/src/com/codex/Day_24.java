package com.codex;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Day_24 {

    // A large object to consume noticeable heap quickly
    static class BigObject {
        // ~1MB array (adjust size if you want more/less)
        private final byte[] payload = new byte[1024 * 1024];
        private final int id;
        BigObject(int id) { this.id = id; }
        @Override public String toString() { return "BigObject-" + id; }
    }

    // ------------- Leak sinks -------------
    // 1) Static list - items never removed -> strong refs keep objects alive
    private static final List<BigObject> STATIC_LEAK = new ArrayList<>();

    // 2) ThreadLocal leak - thread holds a value and thread pool reuses thread, value never removed
    private static final ThreadLocal<BigObject> THREADLOCAL = new ThreadLocal<>();

    // 3) Listener / cache leak - e.g., objects registered and never unregistered
    private static final List<BigObject> LISTENER_LEAK = new ArrayList<>();

    // Aux: thread pool used for threadlocal scenario
    private static final ExecutorService fixedPool = Executors.newFixedThreadPool(4);

    // ------------- Methods that create leaks -------------
    // Add to static list repeatedly
    private static void leakStaticList(int count, int startId) {
        for (int i = 0; i < count; i++) {
            STATIC_LEAK.add(new BigObject(startId + i));
        }
    }

    // Use ThreadLocal inside threads but never remove the value
    private static void leakThreadLocal(int tasks, int startId) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(tasks);
        for (int i = 0; i < tasks; i++) {
            final int id = startId + i;
            fixedPool.submit(() -> {
                // set a BigObject into the thread local and never remove it
                THREADLOCAL.set(new BigObject(id));
                // do some small work
                try { Thread.sleep(50); } catch (InterruptedException ignored) {}
                latch.countDown();
            });
        }
        latch.await();
        // Note: THREADLOCAL values are still referenced by worker threads' Thread objects -> leak
    }

    // Register objects to a global listener list (never unregistered)
    private static void leakListener(int count, int startId) {
        for (int i = 0; i < count; i++) {
            LISTENER_LEAK.add(new BigObject(startId + i));
        }
    }

    // Demonstrate how using WeakReference avoids leak (optional demo)
    private static void weakReferenceDemo(int count, int startId) {
        List<WeakReference<BigObject>> weakList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            weakList.add(new WeakReference<>(new BigObject(startId + i)));
        }
        // trigger GC and show how weak refs can be cleared
        System.gc();
        int alive = 0;
        for (WeakReference<BigObject> wr : weakList) {
            if (wr.get() != null) alive++;
        }
        System.out.println("Weak refs still alive: " + alive + "/" + count);
    }

    // Utility to print memory stats
    private static void printMemoryStats(String tag) {
        Runtime r = Runtime.getRuntime();
        long total = r.totalMemory();
        long free = r.freeMemory();
        long used = total - free;
        System.out.printf("%s => Used: %.2f MB | Free: %.2f MB | Total: %.2f MB | STATIC_LEAK size: %d | THREADLOCAL value? %b | LISTENER_LEAK size: %d%n",
                tag, bytesToMb(used), bytesToMb(free), bytesToMb(total),
                STATIC_LEAK.size(), THREADLOCAL.get() != null, LISTENER_LEAK.size());
    }

    private static double bytesToMb(long b) { return b / 1024.0 / 1024.0; }

    // ------------- Main driver -------------
    public static void main(String[] args) throws Exception {
        System.out.println("JVM Memory Leak Simulation (press Ctrl+C to stop)\n");
        printMemoryStats("Start");

        int id = 0;
        for (int round = 1; round <= 30; round++) {
            System.out.println("\n--- Round " + round + " ---");

            // Create different leaks each round
            leakStaticList(3, id);      // ~3MB per round in static list
            id += 3;
            leakListener(2, id);        // ~2MB per round in listener list
            id += 2;

            // ThreadLocal leak: run a few tasks that set a large object in thread local
            leakThreadLocal(4, id);     // 4 tasks -> up to 4 threads will hold references
            id += 4;

            // Weak-reference demo to contrast
            weakReferenceDemo(5, id);
            id += 5;

            // Ask GC (not guaranteed) and print stats
            System.gc();
            Thread.sleep(500); // give small pause for GC threads
            printMemoryStats("After GC");

            // If heap usage is high, warn and show how to fix
            long usedMb = (long) bytesToMb(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
            if (usedMb > 300) { // adjust threshold based on your JVM heap settings
                System.out.println("Warning: heap used > 300MB (example threshold). Leak patterns are consuming memory.");
            }

            Thread.sleep(400); // brief pause between rounds
        }

        // shutdown pool to exit cleanly
        fixedPool.shutdown();
        fixedPool.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("Done.");
    }
}
