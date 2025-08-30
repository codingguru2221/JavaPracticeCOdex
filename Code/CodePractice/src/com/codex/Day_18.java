package com.codex;

// Definition of a singly linked list node
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Day_18 {

    Node head;

    // Insert at end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Print list
    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }

    // 1️⃣ Reverse Linked List (Iterative)
    public Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;   // store next
            current.next = prev;   // reverse link
            prev = current;        // move prev forward
            current = next;        // move current forward
        }
        return prev; // new head
    }

    // 2️⃣ Detect Cycle (Floyd’s Cycle Detection Algorithm)
    public boolean hasCycle(Node head) {
        if (head == null) return false;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // move by 1
            fast = fast.next.next;   // move by 2

            if (slow == fast) {
                return true; // cycle detected
            }
        }
        return false; // no cycle
    }

    // Test the operations
    public static void main(String[] args) {
        Day_18 list = new Day_18();

        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        System.out.println("Original Linked List:");
        list.printList(list.head);

        // Reverse
        list.head = list.reverse(list.head);
        System.out.println("Reversed Linked List:");
        list.printList(list.head);

        // Detect Cycle
        System.out.println("Has cycle? " + list.hasCycle(list.head));

        // Create cycle manually (5 -> 2)
        list.head.next.next.next.next.next = list.head.next;
        System.out.println("Has cycle after modification? " + list.hasCycle(list.head));
    }
}
