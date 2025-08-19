package com.codex;

import java.util.*;

public class Day_07 {
    public static void main(String[] args) {
        // ---------- LIST ----------
        System.out.println("===== LIST =====");

        // ArrayList
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Apple"); // duplicate allowed
        System.out.println("ArrayList: " + arrayList);

        // LinkedList
        List<String> linkedList = new LinkedList<>();
        linkedList.add("Car");
        linkedList.add("Bike");
        linkedList.add("Car"); // duplicate allowed
        System.out.println("LinkedList: " + linkedList);

        // Vector
        List<String> vector = new Vector<>();
        vector.add("Red");
        vector.add("Green");
        vector.add("Red"); // duplicate allowed
        System.out.println("Vector: " + vector);

        // ---------- SET ----------
        System.out.println("\n===== SET =====");

        // HashSet (unordered, no duplicates)
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Dog");
        hashSet.add("Cat");
        hashSet.add("Dog"); // ignored
        System.out.println("HashSet: " + hashSet);

        // LinkedHashSet (maintains insertion order)
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("One");
        linkedHashSet.add("Two");
        linkedHashSet.add("One"); // ignored
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // TreeSet (sorted order, no duplicates)
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Banana");
        treeSet.add("Apple");
        treeSet.add("Mango");
        treeSet.add("Apple"); // ignored
        System.out.println("TreeSet (Sorted): " + treeSet);

        // ---------- MAP ----------
        System.out.println("\n===== MAP =====");

        // HashMap (unordered)
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Alice");
        hashMap.put(2, "Bob");
        hashMap.put(1, "Charlie"); // key overwritten
        System.out.println("HashMap: " + hashMap);

        // LinkedHashMap (maintains insertion order)
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(10, "India");
        linkedHashMap.put(20, "USA");
        linkedHashMap.put(30, "UK");
        System.out.println("LinkedHashMap: " + linkedHashMap);

        // TreeMap (sorted by keys)
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(300, "Orange");
        treeMap.put(100, "Apple");
        treeMap.put(200, "Banana");
        System.out.println("TreeMap (Sorted by Keys): " + treeMap);
    }
}
