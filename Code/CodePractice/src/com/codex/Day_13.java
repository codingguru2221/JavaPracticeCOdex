package com.codex;

import java.util.*;
import java.util.function.*;

// ---------- OPTIONAL CLASS EXAMPLES ----------
class OptionalExample {
    void show() {
        System.out.println("===== Optional Example =====");

        // Example 1: Creating Optional
        Optional<String> name = Optional.ofNullable("Codex");
        System.out.println("Name: " + name.orElse("Unknown"));

        // Example 2: Empty Optional
        Optional<String> empty = Optional.empty();
        System.out.println("Empty Optional: " + empty.orElse("No Value"));

        // Example 3: ifPresent()
        name.ifPresent(n -> System.out.println("Uppercase: " + n.toUpperCase()));

        // Example 4: map()
        Optional<Integer> length = name.map(String::length);
        System.out.println("Length of name: " + length.orElse(0));

        // Example 5: orElseThrow()
        try {
            System.out.println(empty.orElseThrow(() -> new RuntimeException("Value not found!")));
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}

// ---------- METHOD REFERENCES EXAMPLES ----------
class MethodRefExample {
    static void staticPrint(String msg) {
        System.out.println("Static: " + msg);
    }

    void instancePrint(String msg) {
        System.out.println("Instance: " + msg);
    }

    MethodRefExample(String msg) {
        System.out.println("Constructor: " + msg);
    }

    void show() {
        System.out.println("\n===== Method Reference Example =====");

        List<String> list = Arrays.asList("Java", "Python", "C++");

        // 1. Static method reference
        list.forEach(MethodRefExample::staticPrint);

        // 2. Instance method reference
        MethodRefExample obj = new MethodRefExample("Created Object");
        list.forEach(obj::instancePrint);

        // 3. Constructor reference
        Supplier<MethodRefExample> supplier = () -> new MethodRefExample("Lambda Constructor");
        supplier.get(); // using lambda

        Supplier<MethodRefExample> supplier2 = () -> new MethodRefExample("Normal Constructor Call");
        supplier2.get();

        // Using constructor reference
        Supplier<MethodRefExample> constructorRef = () -> new MethodRefExample("Using Constructor Reference");
        constructorRef.get();
    }
}

// ---------- MAIN CLASS ----------
public class Day_13 {
    public static void main(String[] args) {
        new OptionalExample().show();
        new MethodRefExample("Main Object").show();
    }
}
