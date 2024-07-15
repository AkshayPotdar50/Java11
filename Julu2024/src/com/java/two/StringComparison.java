package com.java.two;

public class StringComparison {
    public static void main(String[] args) {
        // Example strings
        String str1 = "Hello";
        String str2 = "hello";

        // Check if the strings are equal ignoring case
        boolean areEqual = str1.equalsIgnoreCase(str2);

        // Print the result
        if (areEqual) {
            System.out.println("The strings are equal (ignoring case).");
        } else {
            System.out.println("The strings are not equal.");
        }
    }
}

