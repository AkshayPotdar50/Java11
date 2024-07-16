package com.java.Collections.List;

import java.util.Collections;
import java.util.Vector;

public class VectorExamples {

    public static void main(String[] args) {
        // Demonstrate difference between capacity and size
        Vector<Integer> vector = new Vector<>(10);
        System.out.println("Initial capacity: " + vector.capacity());
        System.out.println("Initial size: " + vector.size());

        vector.add(1);
        vector.add(2);
        vector.add(3);
        System.out.println("Capacity after adding 3 elements: " + vector.capacity());
        System.out.println("Size after adding 3 elements: " + vector.size());

        // Synchronize access to a Vector
        Vector<Integer> syncVector = synchronizeVector(vector);
        System.out.println("Synchronized Vector: " + syncVector);

        // Sort elements in a Vector
        sortVector(vector);
        System.out.println("Sorted Vector: " + vector);

        // Find the index of an element in a Vector
        int index = findIndexOfElement(vector, 2);
        System.out.println("Index of element '2': " + index);

        // Remove all occurrences of a specified element in a Vector
        vector.add(2); // Add another '2' to demonstrate removal of all occurrences
        removeAllOccurrences(vector, 2);
        System.out.println("Vector after removing all occurrences of '2': " + vector);
    }

    // Synchronize access to a Vector
    public static Vector<Integer> synchronizeVector(Vector<Integer> vector) {
        return (Vector<Integer>) Collections.synchronizedList(vector);
    }

    // Sort elements in a Vector
    public static void sortVector(Vector<Integer> vector) {
        Collections.sort(vector);
    }

    // Find the index of an element in a Vector
    public static int findIndexOfElement(Vector<Integer> vector, int element) {
        return vector.indexOf(element);
    }

    // Remove all occurrences of a specified element in a Vector
    public static void removeAllOccurrences(Vector<Integer> vector, int element) {
        vector.removeAll(Collections.singleton(element));
    }
}

