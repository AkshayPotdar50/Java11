package com.java.three;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Day11 {
    public static void main(String[] args) {
        String[] arr={"54", "546", "548", "60"};
        String smallest=formSmalletNumber(arr);
        System.out.println(smallest);
    }

    public static String formLargestNumber(String[] arr){
        return Arrays.stream(arr)
                .sorted((num1, num2)->(num2+num1).compareTo(num1+num2))
                .collect(Collectors.joining());
    }

    public static String formSmalletNumber(String[] arr){
        return Arrays.stream(arr).sorted(Comparator.naturalOrder()).collect(Collectors.joining());
    }


    //if array is of integer type
    public static String formSmallestNumber(int[] arr) {
        return Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .sorted((num1, num2) -> (num1 + num2).compareTo(num2 + num1))
                .collect(Collectors.joining());
    }

    public static String findLongestString(String[] strArray) {
        return Arrays.stream(strArray)
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
    }
    public static String findShortestString(String[] strArray) {
        return Arrays.stream(strArray)
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
    }


}
