package com.codex;
import java.util.*;


public class Day_09 {

    // Method to demonstrate HashSet
    public void hashSetExample() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Banana");
        hashSet.add("Apple");
        hashSet.add("Mango");
        hashSet.add("Banana"); // duplicate ignored
        hashSet.add(null);     // null allowed

        System.out.println("===== HashSet =====");
        System.out.println(hashSet); // order not guaranteed
    }

    // Method to demonstrate LinkedHashSet
    public void linkedHashSetExample() {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Banana");
        linkedHashSet.add("Apple");
        linkedHashSet.add("Mango");
        linkedHashSet.add("Banana"); // duplicate ignored
        linkedHashSet.add(null);     // null allowed

        System.out.println("\n===== LinkedHashSet =====");
        System.out.println(linkedHashSet); // maintains insertion order
    }

    // Method to demonstrate TreeSet
    public void treeSetExample() {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Banana");
        treeSet.add("Apple");
        treeSet.add("Mango");
        treeSet.add("Banana"); // duplicate ignored
        // treeSet.add(null); // ❌ would throw NullPointerException

        System.out.println("\n===== TreeSet =====");
        System.out.println(treeSet); // sorted order
    }

    public static void main(String[] args) {
        Day_09 d9 = new Day_09();

        d9.hashSetExample();
        d9.linkedHashSetExample();
        d9.treeSetExample();
    }
}
