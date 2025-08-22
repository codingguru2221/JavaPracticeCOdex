package com.codex;

import java.util.*;

// ---------- QUEUE (LinkedList) EXAMPLE ----------
class QueueExample {
    void show() {
        System.out.println("===== Queue (LinkedList) =====");
        Queue<String> queue = new LinkedList<>();
        queue.add("Apple");
        queue.add("Banana");
        queue.add("Mango");

        System.out.println(queue);          // Insertion order
        System.out.println("Peek: " + queue.peek());   // first element
        System.out.println("Removed: " + queue.poll()); // removes head
        System.out.println("After removal: " + queue);
    }
}

// ---------- PRIORITY QUEUE EXAMPLE ----------
class PriorityQueueExample {
    void show() {
        System.out.println("\n===== PriorityQueue =====");
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min-Heap by default
        pq.add(30);
        pq.add(10);
        pq.add(20);

        System.out.println(pq);                  // Ordered by priority (not strict insertion order)
        System.out.println("Peek: " + pq.peek()); // smallest element
        System.out.println("Removed: " + pq.poll());
        System.out.println("After removal: " + pq);
    }
}

// ---------- DEQUE (ArrayDeque) EXAMPLE ----------
class DequeExample {
    void show() {
        System.out.println("\n===== Deque (ArrayDeque) =====");
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("Front");
        deque.addLast("Back");
        deque.add("Middle");

        System.out.println(deque);                     // [Front, Middle, Back]
        System.out.println("Peek First: " + deque.peekFirst());
        System.out.println("Peek Last: " + deque.peekLast());

        deque.removeFirst();
        deque.removeLast();
        System.out.println("After removing ends: " + deque);
    }
}

// ---------- MAIN CLASS ----------
public class Day_10 {
    public static void main(String[] args) {
        new QueueExample().show();
        new PriorityQueueExample().show();
        new DequeExample().show();
    }
}
