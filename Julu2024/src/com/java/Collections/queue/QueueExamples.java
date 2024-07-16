package com.java.Collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExamples {

    public static void main(String[] args) {
        // Implement circular queue using an array
        CircularQueue circularQueue = new CircularQueue(5);
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        circularQueue.enqueue(4);
        circularQueue.enqueue(5);
        System.out.println("Circular Queue after enqueuing 5 elements: " + circularQueue);
        circularQueue.dequeue();
        System.out.println("Circular Queue after dequeuing 1 element: " + circularQueue);
        circularQueue.enqueue(6);
        System.out.println("Circular Queue after enqueuing 1 element: " + circularQueue);

        // Find the maximum element in a queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        System.out.println("Maximum element in the queue: " + findMaxElement(queue));

        // Reverse the order of elements in a queue
        System.out.println("Queue before reversing: " + queue);
        Queue<Integer> reversedQueue = reverseQueue(queue);
        System.out.println("Queue after reversing: " + reversedQueue);

        // Merge two queues into one
        Queue<Integer> queue1 = new LinkedList<>();
        queue1.add(1);
        queue1.add(3);
        queue1.add(5);

        Queue<Integer> queue2 = new LinkedList<>();
        queue2.add(2);
        queue2.add(4);
        queue2.add(6);

        Queue<Integer> mergedQueue = mergeQueues(queue1, queue2);
        System.out.println("Merged Queue: " + mergedQueue);
    }

    // Circular Queue implementation using an array
    static class CircularQueue {
        private int[] data;
        private int front;
        private int rear;
        private int size;

        public CircularQueue(int capacity) {
            data = new int[capacity];
            front = -1;
            rear = -1;
            size = 0;
        }

        public void enqueue(int value) {
            if (isFull()) {
                throw new IllegalStateException("Queue is full");
            }
            if (isEmpty()) {
                front = 0;
            }
            rear = (rear + 1) % data.length;
            data[rear] = value;
            size++;
        }

        public int dequeue() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            int value = data[front];
            front = (front + 1) % data.length;
            size--;
            if (isEmpty()) {
                front = -1;
                rear = -1;
            }
            return value;
        }

        public boolean isFull() {
            return size == data.length;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < size; i++) {
                sb.append(data[(front + i) % data.length]);
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    // Find the maximum element in a queue
    public static int findMaxElement(Queue<Integer> queue) {
        return queue.stream().max(Integer::compare).orElseThrow();
    }

    // Reverse the order of elements in a queue
    public static Queue<Integer> reverseQueue(Queue<Integer> queue) {
        LinkedList<Integer> stack = new LinkedList<>();
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        return queue;
    }

    // Merge two queues into one
    public static Queue<Integer> mergeQueues(Queue<Integer> queue1, Queue<Integer> queue2) {
        Queue<Integer> mergedQueue = new LinkedList<>(queue1);
        mergedQueue.addAll(queue2);
        return mergedQueue;
    }
}

