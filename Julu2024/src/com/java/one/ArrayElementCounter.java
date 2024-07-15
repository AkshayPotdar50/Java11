package com.java.one;

public class ArrayElementCounter {
    public static void main(String[] args) {
        int[] array = {5, 10, 15, 20, 25, 30, 35, 40};
        int divisor = 5;
        int threshold = 20;
        int lowerBound = 15;
        int upperBound = 35;

        System.out.println("Number of elements divisible by " + divisor + ": " + countDivisibleBy(array, divisor));
        System.out.println("Number of elements greater than " + threshold + ": " + countGreaterThan(array, threshold));
        System.out.println("Number of elements less than " + threshold + ": " + countLessThan(array, threshold));
        System.out.println("Number of elements between " + lowerBound + " and " + upperBound + ": " + countBetween(array, lowerBound, upperBound));
    }

    public static int countDivisibleBy(int[] array, int divisor) {
        int count = 0;
        for (int element : array) {
            if (element % divisor == 0) {
                count++;
            }
        }
        return count;
    }

    public static int countGreaterThan(int[] array, int threshold) {
        int count = 0;
        for (int element : array) {
            if (element > threshold) {
                count++;
            }
        }
        return count;
    }

    public static int countLessThan(int[] array, int threshold) {
        int count = 0;
        for (int element : array) {
            if (element < threshold) {
                count++;
            }
        }
        return count;
    }

    public static int countBetween(int[] array, int lowerBound, int upperBound) {
        int count = 0;
        for (int element : array) {
            if (element >= lowerBound && element <= upperBound) {
                count++;
            }
        }
        return count;
    }
}
