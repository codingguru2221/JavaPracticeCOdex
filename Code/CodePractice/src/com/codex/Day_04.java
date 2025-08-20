package com.codex;

// ---------------------------
// 1. String (Immutable)
// ---------------------------
class StringExample {
    public void runDemo() {
        String str = "Hello";
        str.concat(" World"); // Doesn't change original
        System.out.println("String result: " + str); // Output: Hello
    }
}

// ---------------------------
// 2. StringBuilder (Mutable, not thread-safe)
// ---------------------------
class StringBuilderExample {
    public void runDemo() {
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println("StringBuilder result: " + sb); // Output: Hello World
    }
}

// ---------------------------
// 3. StringBuffer (Mutable, thread-safe)
// ---------------------------
class StringBufferExample {
    public void runDemo() {
        StringBuffer sbf = new StringBuffer("Hello");
        sbf.append(" World");
        System.out.println("StringBuffer result: " + sbf); // Output: Hello World
    }
}

// ---------------------------
// 4. Performance Test
// ---------------------------
class PerformanceTest {
    private static final int ITERATIONS = 100000;

    public void runDemo() {
        // String performance
        long start = System.nanoTime();
        String s = "Hello";
        for (int i = 0; i < ITERATIONS; i++) {
            s += " World"; // Creates new object each time
        }
        long end = System.nanoTime();
        System.out.println("String time: " + (end - start) / 1_000_000 + " ms");

        // StringBuilder performance
        start = System.nanoTime();
        StringBuilder sbPerf = new StringBuilder("Hello");
        for (int i = 0; i < ITERATIONS; i++) {
            sbPerf.append(" World");
        }
        end = System.nanoTime();
        System.out.println("StringBuilder time: " + (end - start) / 1_000_000 + " ms");

        // StringBuffer performance
        start = System.nanoTime();
        StringBuffer sbfPerf = new StringBuffer("Hello");
        for (int i = 0; i < ITERATIONS; i++) {
            sbfPerf.append(" World");
        }
        end = System.nanoTime();
        System.out.println("StringBuffer time: " + (end - start) / 1_000_000 + " ms");
    }
}

// ---------------------------
// Main Driver
// ---------------------------
public class Day_04 {
    public static void main(String[] args) {
        System.out.println("=== String Example ===");
        new StringExample().runDemo();

        System.out.println("\n=== StringBuilder Example ===");
        new StringBuilderExample().runDemo();

        System.out.println("\n=== StringBuffer Example ===");
        new StringBufferExample().runDemo();

        System.out.println("\n=== Performance Test ===");
        new PerformanceTest().runDemo();
    }
}
