package com.java.two;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepating {
    public static void main(String[] args) {
        String input="abcabcbb";

        int length=lengthOfLongestSubstring(input);
        System.out.println("length of longest substring without repating character is:"+length);

    }

    public static int lengthOfLongestSubstring(String s){
        int n=s.length();
        int maxLength=0;

        //set to store unique character
        Set<Character> set= new HashSet<>();

        //two pointers techenique
        int i=0, j=0;

        while(i<n && j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                maxLength=Math.max(maxLength, j-i);
            }else{
                set.remove(s.charAt(i));
                i++;
            }

        }
        return maxLength;
    }
}
