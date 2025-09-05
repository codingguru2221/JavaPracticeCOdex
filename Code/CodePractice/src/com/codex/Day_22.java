package com.codex;

// Shared Resource (Buffer)
class Buffer {
    private int data;
    private boolean isEmpty = true;

    // Producer puts data
    public synchronized void produce(int value) {
        while (!isEmpty) { // Wait if buffer is full
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        data = value;
        isEmpty = false;
        System.out.println("Produced: " + value);
        notify(); // Notify consumer
    }

    // Consumer takes data
    public synchronized int consume() {
        while (isEmpty) { // Wait if buffer is empty
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isEmpty = true;
        System.out.println("Consumed: " + data);
        notify(); // Notify producer
        return data;
    }
}

// Producer Thread
class Producer extends Thread {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.produce(i);
            try {
                Thread.sleep(500); // Simulate time to produce
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Consumer Thread
class Consumer extends Thread {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.consume();
            try {
                Thread.sleep(1000); // Simulate time to consume
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Main Class
public class Day_22 {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}
