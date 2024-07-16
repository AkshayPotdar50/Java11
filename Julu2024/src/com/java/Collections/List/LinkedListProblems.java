package com.java.Collections.List;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LinkedListProblems {

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        LinkedList<Integer> list2 = new LinkedList<>(Arrays.asList(3, 4, 5, 6, 7));

        System.out.println("Reversed LinkedList: " + reverse(list1));
        System.out.println("LinkedList without Duplicates: " + removeDuplicates(list1));
        System.out.println("Middle Element of LinkedList: " + findMiddle(list1));
        System.out.println("Is LinkedList Palindrome: " + isPalindrome(list1));
        System.out.println("Merged Sorted LinkedLists: " + mergeSortedLists(list1, list2));
        System.out.println("Intersection Point: " + findIntersectionPoint(list1, list2));
        System.out.println("3rd Node from End: " + findNthFromEnd(list1, 3));
        System.out.println("Has Cycle: " + hasCycle(list1));
    }

    // Reverse LinkedList
    public static LinkedList<Integer> reverse(LinkedList<Integer> list) {
        return list.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), l -> {
                    Collections.reverse(l);
                    return new LinkedList<>(l);
                }));
    }

    // Remove Duplicates from LinkedList
    public static LinkedList<Integer> removeDuplicates(LinkedList<Integer> list) {
        return list.stream()
                .distinct()
                .collect(Collectors.toCollection(LinkedList::new));
    }

    // Find Middle Element of LinkedList
    public static Integer findMiddle(LinkedList<Integer> list) {
        return list.stream()
                .skip(list.size() / 2)
                .findFirst()
                .orElse(null);
    }

    // Check if LinkedList is Palindrome
    public static boolean isPalindrome(LinkedList<Integer> list) {
        List<Integer> reversedList = list.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), l -> {
                    Collections.reverse(l);
                    return l;
                }));
        return list.equals(reversedList);
    }

    // Merge Two Sorted LinkedLists
    public static LinkedList<Integer> mergeSortedLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        return Stream.concat(list1.stream(), list2.stream())
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));
    }

    // Find Intersection Point of Two LinkedLists
    public static Integer findIntersectionPoint(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        Set<Integer> set = new HashSet<>(list1);
        return list2.stream()
                .filter(set::contains)
                .findFirst()
                .orElse(null);
    }

    // Find Nth Node from End of LinkedList
    public static Integer findNthFromEnd(LinkedList<Integer> list, int n) {
        return list.stream()
                .skip(list.size() - n)
                .findFirst()
                .orElse(null);
    }

    // Detect Cycle in LinkedList
    public static boolean hasCycle(LinkedList<Integer> list) {
        Set<Integer> seen = new HashSet<>();
        for (Integer element : list) {
            if (!seen.add(element)) {
                return true;
            }
        }
        return false;
    }
}

