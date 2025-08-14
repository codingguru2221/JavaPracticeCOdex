package com.codex;

//        Today is the Day 01 of practice java and today i am Learning about
//        OOP principles, Access Modifiers

//        OOP Principals

// 1) Encapsulation

class BankAccount {
    private String accountNumber;  // Private field
    private double balance;

    // Public getter method
    public double getBalance() {
        return balance;
    }

    // Public setter method (with validation)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}

// 2) Inheritance

// Parent class

class Animal {
    public void eat() {
        System.out.println("Animal is eating");
    }
}

// Child class
class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("Dog is eating bones");
    }

    public void bark() {
        System.out.println("Woof!");
    }
}

// 3) Polymorphism
// Compile-time Polymorphism (Method Overloading)
class Calculator {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
}

//Runtime Polymorphism (Method Overriding)
class Animal1 { void sound() { System.out.println("Some sound"); } }
class Cat extends Animal1 {
    @Override
    void sound() { System.out.println("Meow"); }
}

// 4) Abstraction

abstract class Shape {
    abstract double area();  // Abstract method (no implementation)
    void display() { System.out.println("This is a shape"); }
}

//Interfaces (interface keyword)
interface Drawable {
    void draw();
}
class Circle implements Drawable {
    @Override
    public void draw() { System.out.println("Drawing a circle"); }
}

abstract class Vehicle {
    abstract void start();  // Must be implemented by subclasses
}

class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("Car starts with a key");
    }
}


/**
 * This class demonstrates all Java access modifiers in one place.
 * Shows public, protected, default (package-private), and private access.
 */
class AccessModifiersDemo {
    // ========== FIELD DECLARATIONS WITH DIFFERENT ACCESS LEVELS ==========
    public int publicVar = 1;           // Accessible everywhere
    protected int protectedVar = 2;     // Accessible in package + subclasses
    int defaultVar = 3;                 // Accessible only in package (no modifier)
    private int privateVar = 4;         // Accessible only in this class

    // ========== METHOD DECLARATIONS WITH DIFFERENT ACCESS LEVELS ==========
    public void publicMethod() {
        System.out.println("Public method - accessible from anywhere");
        System.out.println("Accessing privateVar from within class: " + privateVar);
    }

    protected void protectedMethod() {
        System.out.println("Protected method - accessible in package and subclasses");
    }

    void defaultMethod() {
        System.out.println("Default method - accessible only in package");
    }

    private void privateMethod() {
        System.out.println("Private method - accessible only in this class");
    }

    // ========== DEMONSTRATING ACCESS WITHIN THE SAME CLASS ==========
    public void demonstrateAccess() {
        // All access levels are accessible within the same class
        System.out.println("\n=== Access from within the same class ===");
        System.out.println("publicVar: " + publicVar);
        System.out.println("protectedVar: " + protectedVar);
        System.out.println("defaultVar: " + defaultVar);
        System.out.println("privateVar: " + privateVar);

        publicMethod();
        protectedMethod();
        defaultMethod();
        privateMethod();
    }

    // ========== INNER CLASS TO DEMONSTRATE PROTECTED ACCESS ==========
    protected class InnerProtectedClass {
        public void showAccess() {
            System.out.println("\n=== Access from inner protected class ===");
            System.out.println("Can access protectedVar: " + protectedVar);
        }
    }

    public static void main(String[] args) {
        AccessModifiersDemo demo = new AccessModifiersDemo();

        // 1. Demonstrate all access within the same class
        demo.demonstrateAccess();

        // 2. Demonstrate protected access via inner class
        InnerProtectedClass inner = demo.new InnerProtectedClass();
        inner.showAccess();

        // 3. Attempt to access private members (would cause compilation error)
        // System.out.println(demo.privateVar);       // Error
        // demo.privateMethod();                     // Error

        System.out.println("\n=== Access Summary ===");
        System.out.println("publicVar is accessible everywhere");
        System.out.println("protectedVar is accessible in package and subclasses");
        System.out.println("defaultVar is accessible only in package");
        System.out.println("privateVar is accessible only in this class");
    }
}

public class Day_01 {
    public static void main(String[] args) {
        // Usage of bank account class
        BankAccount account = new BankAccount();
        account.deposit(1000);
        System.out.println(account.getBalance());  // Output: 1000.0

        // Usage of the animal class
        Dog dog = new Dog();
        dog.eat();  // Output: "Dog is eating bones" (overridden method)
        dog.bark(); // Output: "Woof!" (Dog's own method)

        // Usage
        Animal1 animal = new Animal1();
        Animal1 cat = new Cat();

        animal.sound();  // Output: "Some sound"
        cat.sound();     // Output: "Meow" (Runtime polymorphism)

        // Usage
        Vehicle car = new Car();
        car.start();  // Output: "Car starts with a key"
    }
}
