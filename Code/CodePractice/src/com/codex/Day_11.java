package com.codex;

import java.util.*;
import java.util.stream.*;

class IteratorExample {
    void show() {
        System.out.println("===== Iterator Example =====");
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Mango");

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

class ForEachExample {
    void show() {
        System.out.println("===== forEach Example =====");
        List<String> list = Arrays.asList("Apple", "Banana", "Mango");

        // Using Lambda Expression
        list.forEach(item -> System.out.println(item));

        // Using Method Reference
        list.forEach(System.out::println);
    }
}

class StreamExample {
    void show() {
        System.out.println("===== Streams Example =====");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Filtering even numbers
        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even Numbers: " + evens);

        // Mapping: square each number
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squares: " + squares);

        // Reduce: sum of numbers
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
    }
}

public class Day_11 {
    public static void main(String[] args) {
        IteratorExample ITR = new IteratorExample();
        ITR.show();
        ForEachExample FE = new ForEachExample();
        FE.show();
        StreamExample SE = new StreamExample();
        SE.show();
    }
}
