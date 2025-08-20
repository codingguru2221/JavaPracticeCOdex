package com.codex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Class for ArrayList operations
class ArrayListExample {
    private List<String> arrayList;

    public ArrayListExample() {
        arrayList = new ArrayList<>();
    }

    public void runDemo() {
        arrayList.add("Java");
        arrayList.add("Python");
        arrayList.add("C++");

        System.out.println("ArrayList: " + arrayList);
        System.out.println("Access ArrayList[1]: " + arrayList.get(1)); // O(1)

        // Insert in middle
        arrayList.add(1, "Go");
        System.out.println("After inserting at index 1: " + arrayList);
    }
}

// Class for LinkedList operations
class LinkedListExample {
    private List<String> linkedList;

    public LinkedListExample() {
        linkedList = new LinkedList<>();
    }

    public void runDemo() {
        linkedList.add("Java");
        linkedList.add("Python");
        linkedList.add("C++");

        System.out.println("LinkedList: " + linkedList);
        System.out.println("Access LinkedList[1]: " + linkedList.get(1)); // O(n)

        // Insert in middle
        linkedList.add(1, "Go");
        System.out.println("After inserting at index 1: " + linkedList);
    }
}

// Main class
public class Day_08 {
    public static void main(String[] args) {
        System.out.println("=== ArrayList Demo ===");
        ArrayListExample arrayListDemo = new ArrayListExample();
        arrayListDemo.runDemo();

        System.out.println("\n=== LinkedList Demo ===");
        LinkedListExample linkedListDemo = new LinkedListExample();
        linkedListDemo.runDemo();
    }
}
