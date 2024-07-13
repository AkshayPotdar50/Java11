package com.java.one;

import java.util.HashMap;
import java.util.Map;

public class ElementFrequency {
    public static void main(String[] args) {

        int[] arr={1, 2, 2, 3, 4,3, 4, 3, 4, 4, 5, 5, 4, 7, 8, 8, 9};

        Map<Integer, Integer> frequncyMap=findFrequencies(arr);
        for(Map.Entry<Integer, Integer> entry: frequncyMap.entrySet()){
            System.out.println("element:"+entry.getKey()+ "frequency:"+entry.getValue());
        }

    }



    public static Map<Integer, Integer> findFrequencies(int[] arr){
        Map<Integer, Integer> frequencyMap= new HashMap<>();

        for(int num:arr){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
        }
        return frequencyMap;
    }
}
