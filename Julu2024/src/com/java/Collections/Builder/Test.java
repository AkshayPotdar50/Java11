package com.java.Collections.Builder;

import java.util.*;
import java.util.stream.Collectors;

public class Test {


    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4};
        Integer[] arr2 = {5, 4, 7, 8};
        System.out.println(Arrays.toString(findIntersection(arr, arr2)));

    }

    public static Integer[] findIntersection(Integer[] arr, Integer[] arr2){

        Set<Integer> set1=Arrays.stream(arr2).collect(Collectors.toSet());

        List<Integer> intersection=Arrays.stream(arr)
                .filter(set1::contains).distinct().toList();

        return intersection.toArray(new Integer[0]);
    }
}




