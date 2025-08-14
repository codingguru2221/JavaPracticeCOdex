package com.codex;

//  static
class Example {
    static int count = 0; // Shared variable

    static void displayCount() {
        System.out.println("Count: " + count);
    }
}
//  final
final class Parent { // Cannot be inherited
    final void show() { // Cannot be overridden
        System.out.println("Hello");
    }
}
//  this
class Example1 {
    int x;

    Example1(int x) {
        this.x = x; // Refers to instance variable
    }

    void show() {
        System.out.println("x = " + this.x);
    }
}

//  super
class Parent1 {
    String name = "Parent";
    void display() {
        System.out.println("In Parent");
    }
}

class Child extends Parent1 {
    String name = "Child";

    void show() {
        System.out.println(super.name); // Access parent variable
        super.display(); // Call parent method
    }
}


public class Day_02 {
    public static void main(String[] args) {
//        static
        Example.count = 5;
        Example.displayCount(); // No object needed

//        final
        final int x = 10;
        // x = 20; // ❌ Error: cannot change final variable
        System.out.println(x);

    }
}
