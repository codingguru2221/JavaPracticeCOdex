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
    }
}
