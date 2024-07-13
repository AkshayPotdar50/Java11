package com.java.one;

import java.util.Random;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 19};
        int k = 2; // Find the 2nd largest element
        System.out.println("The " + k + "th largest element is: " + findKthLargest(arr, k));
    }

    public static int findKthLargest(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, arr.length - k);
    }

    private static int quickSelect(int[] arr, int low, int high, int k) {
        if (low == high) {
            return arr[low];
        }

        Random rand = new Random();
        int pivotIndex = low + rand.nextInt(high - low + 1);
        pivotIndex = partition(arr, low, high, pivotIndex);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelect(arr, low, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, high, k);
        }
    }

    private static int partition(int[] arr, int low, int high, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, high);
        int storeIndex = low;

        for (int i = low; i < high; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }

        swap(arr, storeIndex, high);
        return storeIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
