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
