package com.java.Collections.List;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ArrayListProblems {

    public static void main(String[] args) {
        List<Integer> arrayList = List.of(10, 22, 9, 33, 21, 50, 41, 60, 80);

        System.out.println("Longest Increasing Subsequence Length: " + lis(arrayList));
        System.out.println("Longest Decreasing Subsequence Length: " + lds(arrayList));
        System.out.println("Longest Bitonic Subsequence Length: " + lbs(arrayList));
        System.out.println("Longest Alternating Subsequence Length: " + las(arrayList));

        List<Integer> binaryList = List.of(0, 0, 1, 0, 1, 1, 0);
        System.out.println("Longest Sublist with Equal 0s and 1s Length: " + longestSublistEqualZeroesAndOnes(binaryList));

        int k = 5;
        List<Integer> arrayList2 = List.of(2, 7, 6, 1, 4, 5);
        System.out.println("Longest Sublist with Sum Divisible by " + k + " Length: " + longestSublistWithSumDivisibleByK(arrayList2, k));
        System.out.println("Longest Sublist with No Repeating Elements Length: " + longestSublistWithNoRepeatingElements(arrayList2));
        System.out.println("Longest Sublist with At Most Two Different Elements Length: " + longestSublistWithAtMostTwoDifferentElements(arrayList2));

    }

    // Longest Increasing Subsequence
    public static int lis(List<Integer> arrayList) {
        if (arrayList.isEmpty()) return 0;
        int[] lis = new int[arrayList.size()];
        Arrays.fill(lis, 1);

        IntStream.range(1, arrayList.size()).forEach(i ->
                IntStream.range(0, i).forEach(j -> {
                    if (arrayList.get(i) > arrayList.get(j) && lis[i] < lis[j] + 1) {
                        lis[i] = lis[j] + 1;
                    }
                })
        );

        return Arrays.stream(lis).max().orElse(1);
    }

    // Longest Decreasing Subsequence
    public static int lds(List<Integer> arrayList) {
        if (arrayList.isEmpty()) return 0;
        int[] lds = new int[arrayList.size()];
        Arrays.fill(lds, 1);

        IntStream.range(1, arrayList.size()).forEach(i ->
                IntStream.range(0, i).forEach(j -> {
                    if (arrayList.get(i) < arrayList.get(j) && lds[i] < lds[j] + 1) {
                        lds[i] = lds[j] + 1;
                    }
                })
        );

        return Arrays.stream(lds).max().orElse(1);
    }

    // Longest Bitonic Subsequence
    public static int lbs(List<Integer> arrayList) {
        if (arrayList.isEmpty()) return 0;
        int[] lis = new int[arrayList.size()];
        int[] lds = new int[arrayList.size()];
        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);

        // Compute LIS values
        IntStream.range(1, arrayList.size()).forEach(i ->
                IntStream.range(0, i).forEach(j -> {
                    if (arrayList.get(i) > arrayList.get(j) && lis[i] < lis[j] + 1) {
                        lis[i] = lis[j] + 1;
                    }
                })
        );

        // Compute LDS values
        IntStream.range(1, arrayList.size()).forEach(i ->
                IntStream.range(0, i).forEach(j -> {
                    if (arrayList.get(i) < arrayList.get(j) && lds[i] < lds[j] + 1) {
                        lds[i] = lds[j] + 1;
                    }
                })
        );

        int maxBitonic = IntStream.range(0, arrayList.size())
                .map(i -> lis[i] + lds[i] - 1)
                .max()
                .orElse(1);

        return maxBitonic;
    }

    // Longest Alternating Subsequence
    public static int las(List<Integer> arrayList) {
        if (arrayList.isEmpty()) return 0;
        int[] las = new int[arrayList.size()];
        Arrays.fill(las, 1);

        IntStream.range(1, arrayList.size()).forEach(i ->
                IntStream.range(0, i).forEach(j -> {
                    if ((arrayList.get(i) > arrayList.get(j) && las[i] < las[j] + 1) ||
                            (arrayList.get(i) < arrayList.get(j) && las[i] < las[j] + 1)) {
                        las[i] = las[j] + 1;
                    }
                })
        );

        return Arrays.stream(las).max().orElse(1);
    }

    // Longest Sublist with Equal 0s and 1s
    public static int longestSublistEqualZeroesAndOnes(List<Integer> arrayList) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0, count = 0;

        for (int i = 0; i < arrayList.size(); i++) {
            count += arrayList.get(i) == 0 ? -1 : 1;

            if (count == 0) {
                maxLength = i + 1;
            }

            if (map.containsKey(count)) {
                maxLength = Math.max(maxLength, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }

        return maxLength;
    }

    // Longest Sublist with Sum Divisible by K
    public static int longestSublistWithSumDivisibleByK(List<Integer> arrayList, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0, sum = 0;

        for (int i = 0; i < arrayList.size(); i++) {
            sum += arrayList.get(i);
            int mod = ((sum % k) + k) % k;

            if (mod == 0) {
                maxLength = i + 1;
            }

            if (map.containsKey(mod)) {
                maxLength = Math.max(maxLength, i - map.get(mod));
            } else {
                map.put(mod, i);
            }
        }

        return maxLength;
    }

    // Longest Sublist with No Repeating Elements
    public static int longestSublistWithNoRepeatingElements(List<Integer> arrayList) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0, start = 0;

        for (int end = 0; end < arrayList.size(); end++) {
            if (map.containsKey(arrayList.get(end))) {
                start = Math.max(start, map.get(arrayList.get(end)) + 1);
            }
            map.put(arrayList.get(end), end);
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    // Longest Sublist with At Most Two Different Elements
    public static int longestSublistWithAtMostTwoDifferentElements(List<Integer> arrayList) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0, start = 0;

        for (int end = 0; end < arrayList.size(); end++) {
            map.put(arrayList.get(end), map.getOrDefault(arrayList.get(end), 0) + 1);

            while (map.size() > 2) {
                map.put(arrayList.get(start), map.get(arrayList.get(start)) - 1);
                if (map.get(arrayList.get(start)) == 0) {
                    map.remove(arrayList.get(start));
                }
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }


}