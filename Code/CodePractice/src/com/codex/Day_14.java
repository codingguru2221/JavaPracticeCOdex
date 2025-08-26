package com.codex;

import java.util.*;

// Student class implementing Comparable
class Student implements Comparable<Student> {
    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Natural ordering by id
    @Override
    public int compareTo(Student other) {
        return this.id - other.id; // ascending order
    }

    @Override
    public String toString() {
        return id + " - " + name + " (" + marks + ")";
    }
}

public class Day_14 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(3, "Aman", 75));
        list.add(new Student(1, "Riya", 88));
        list.add(new Student(2, "Karan", 65));

        // Using Comparable (Natural Order by ID)
        Collections.sort(list);
        System.out.println("Sorted by ID (Comparable):");
        for (Student s : list) {
            System.out.println(s);
        }

        // Using Comparator (Custom Order by Name)
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.name.compareTo(s2.name); // alphabetic order
            }
        });
        System.out.println("\nSorted by Name (Comparator):");
        for (Student s : list) {
            System.out.println(s);
        }

        // Using Comparator with Lambda (Sort by Marks descending)
        list.sort((s1, s2) -> s2.marks - s1.marks);
        System.out.println("\nSorted by Marks (Comparator - Lambda):");
        for (Student s : list) {
            System.out.println(s);
        }
    }
}
