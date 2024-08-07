package com.java.three;

import java.util.HashMap;

public class LongestSubstringKDistinct {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        int left = 0, right = 0;
        int maxLength = 0;
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            charCountMap.put(rightChar, charCountMap.getOrDefault(rightChar, 0) + 1);
            right++;

            while (charCountMap.size() > k) {
                char leftChar = s.charAt(left);
                charCountMap.put(leftChar, charCountMap.get(leftChar) - 1);
                if (charCountMap.get(leftChar) == 0) {
                    charCountMap.remove(leftChar);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println("Length of the longest substring with at most " + k + " distinct characters: " + lengthOfLongestSubstringKDistinct(s, k));
    }
}

