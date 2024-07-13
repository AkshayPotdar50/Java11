package com.java.one;

public class MaxConsecutiveSum {
    public static void main(String[] args) {
        int[] arr={1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println("maximum consecutive sum is :"+findMaxConsecutiveSum(arr));

        System.out.println("minimum consecutive sum is:"+findMinConsecutiveSum(arr));


    }

    public static int findMaxConsecutiveSum(int[] arr){
        int maxSoFar= arr[0];
        int maxEndingHere=arr[0];

        for(int i=1; i<arr.length; i++){
            maxEndingHere=Math.max(arr[i], maxEndingHere+arr[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);

        }
        return maxSoFar;
    }

    public static int findMinConsecutiveSum(int[] arr){
        int minSoFar=arr[0];
        int minEndingHere=arr[0];

        for(int i=0; i<arr.length;i++){
            minEndingHere=Math.min(arr[i], minEndingHere+arr[i]);
            minSoFar=Math.min(minSoFar, minEndingHere);

        }
        return minSoFar;
    }
}
