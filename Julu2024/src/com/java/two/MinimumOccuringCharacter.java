package com.java.two;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinimumOccuringCharacter {
    public static void main(String[] args) {
        String input="example string to find minimum occuring";
        char minChar=findMinimumOccuringCharacter(input);
        System.out.println("the minimum occuring character is :"+minChar);
    }

    public static char findMinimumOccuringCharacter(String str){
        if(str ==null || str.isEmpty()){
            throw new IllegalArgumentException("input cannot be null or empty");

        }
        Map<Character, Long> charCount=str.chars()
                .filter(ch->!Character.isWhitespace(ch))
                .mapToObj(ch->(char)ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return charCount.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow(()->new RuntimeException("no non whitespace character found"));


    }
}
