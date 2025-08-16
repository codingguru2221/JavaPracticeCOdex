package com.codex;

public class Day_04 {
    public static void main(String[] args) {
        // ---------------------------
        // 1. String (Immutable)
        // ---------------------------
        String str = "Hello";
        str.concat(" World"); // Doesn't change original
        System.out.println("String result: " + str); // Output: Hello

        // ---------------------------
        // 2. StringBuilder (Mutable, not thread-safe)
        // ---------------------------
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println("StringBuilder result: " + sb); // Output: Hello World

        // ---------------------------
        // 3. StringBuffer (Mutable, thread-safe)
        // ---------------------------
        StringBuffer sbf = new StringBuffer("Hello");
        sbf.append(" World");
        System.out.println("StringBuffer result: " + sbf); // Output: Hello World

        // ---------------------------
        // Performance Test
        // ---------------------------
        int iterations = 100000;

        // String performance
        long start = System.nanoTime();
        String s = "Hello";
        for (int i = 0; i < iterations; i++) {
            s += " World"; // Creates new object each time
        }
        long end = System.nanoTime();
        System.out.println("String time: " + (end - start) / 1_000_000 + " ms");

        // StringBuilder performance
        start = System.nanoTime();
        StringBuilder sbPerf = new StringBuilder("Hello");
        for (int i = 0; i < iterations; i++) {
            sbPerf.append(" World");
        }
        end = System.nanoTime();
        System.out.println("StringBuilder time: " + (end - start) / 1_000_000 + " ms");

        // StringBuffer performance
        start = System.nanoTime();
        StringBuffer sbfPerf = new StringBuffer("Hello");
        for (int i = 0; i < iterations; i++) {
            sbfPerf.append(" World");
        }
        end = System.nanoTime();
        System.out.println("StringBuffer time: " + (end - start) / 1_000_000 + " ms");
    }
}
