package com.java.stream1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {

    /*Problem 2: Distinct, Sorted, Limit, and Collect (toList)
Given: A list of integers representing product prices.

Task: Retrieve the top 5 unique, highest prices in descending order.
Operations: distinct, sorted, limit, collect*/

    public static void main(String[] args) {
        List<Integer> prices= Arrays.asList(250, 150, 100, 360, 852, 147, 541);

        List<Integer> top5=prices.stream().distinct().sorted(Comparator.reverseOrder()).limit(5).toList();
        System.out.println(top5);
    }
}
