package com.codex;


//Interfaces in Java
interface Animal3 {
    void sound();  // abstract method
}

class Dog1 implements Animal3 {
    public void sound() {
        System.out.println("Bark");
    }
}

//Abstract Classes in Java
abstract class Animal4 {
    String name;

    Animal4(String name) {
        this.name = name;
    }

    abstract void sound(); // must be implemented by subclasses

    void eat() {
        System.out.println(name + " is eating");
    }
}

class Dog2 extends Animal {
    Dog2(String name) {
//        super(name);
    }
    void sound() {
        System.out.println("Bark");
    }
}

//Functional Interfaces in Java
@FunctionalInterface
interface MyPrinter {
    void print(String message);
}



public class Day_03 {
    public static void main(String[] args) {
        MyPrinter printer = (msg) -> System.out.println(msg);
        printer.print("Hello from Lambda!");
    }
}
