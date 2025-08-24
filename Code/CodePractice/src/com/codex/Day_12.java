package com.codex;

import java.util.*;

// ---------- MAP EXAMPLE ----------
class MapExample1 {
    void show() {
        List<String> names = Arrays.asList("codex", "java", "stream");

        List<String> upperNames = names.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println("Map Example: " + upperNames);
        // [CODEX, JAVA, STREAM]
    }
}


// ---------- FILTER EXAMPLE ----------
class FilterExample {
    void show() {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);

        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        System.out.println("Filter Example: " + evens);
        // [10, 20, 30]
    }
}


// ---------- REDUCE EXAMPLE ----------
class ReduceExample {
    void show() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

        int sum = nums.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("Reduce Example (Sum): " + sum);
        // 15
    }
}


// ---------- COMBINED EXAMPLE ----------
class CombinedExample {
    void show() {
        List<Integer> list = Arrays.asList(2, 3, 4, 5, 6);

        int result = list.stream()
                .filter(n -> n % 2 == 0)       // even numbers
                .map(n -> n * n)              // square them
                .reduce(0, Integer::sum);     // sum them

        System.out.println("Combined Example (Sum of Squares of Evens): " + result);
        // 56
    }
}


// ---------- MAIN CLASS ----------
public class Day_12 {
    public static void main(String[] args) {
        new MapExample1().show();
        new FilterExample().show();
        new ReduceExample().show();
        new CombinedExample().show();
    }
}
