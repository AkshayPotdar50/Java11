package com.java.Collections.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ArraylistOpeartions {


    //method to add elements in arraylist
    public static void addElements(ArrayList<Integer> arrayList, int[] elements){
        for(int num:elements){
            arrayList.add(num);
        }
    }

    //method to remove elements arralist based on condition
    public static List<Integer> removeElements(ArrayList<Integer> arraylist, Condition condition){
        return arraylist.stream()
                .filter(element->!condition.test(element))
                .collect(Collectors.toList());
    }

    //method to find the largest number in arraylist
    public static int findLargestNumber(List<Integer> arrayList){
        return arrayList.stream().max(Integer::compare).orElseThrow(()-> new IllegalArgumentException("arraylist nahi aahe"));
    }





}
interface Condition{
    boolean test(int element);
}
