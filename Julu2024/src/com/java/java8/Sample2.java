package com.java.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sample2 {
    public static void main(String[] args) {

        //use cases of Collectors.joining()
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        String result= String.join(" ,", names);
        String result2=names.stream().collect(Collectors.joining(",", "Names:[",""));

        List<Character> chars=Arrays.asList('J', 'A', 'V', 'A');
        String result3=chars.stream().map(String::valueOf).collect(Collectors.joining());




    }

    //filter even numbers
    public static List<Integer> filterEvenNumbers(List<Integer> list){
        return list.stream().filter(n->n % 2==0).collect(Collectors.toList());
    }

    //calculate sum
    public static int calculateSum(List<Integer> list){
        return list.stream().reduce(0, Integer::sum);
    }

    //maximum number in list
    public static int findMaxNumbers(List<Integer> numbers){
        Optional<Integer> max=numbers.stream().max(Integer::compareTo);
        return max.orElse(Integer.MIN_VALUE);
    }

    //check list contains specific elements
    public static boolean checkIfContainsNumber(List<Integer> number, int target){
        return number.stream().anyMatch(n-> n==target);
    }

    //find sum of all even numbers
    public static int sumOfEvenNumbers(List<Integer> numbers){
        return numbers.stream().filter(n->n %2 ==0).reduce(0, Integer::sum);
    }

    //how to concatenate string in java
    public static String concatenateString(List<String> strings){
        return String.join("", strings);
    }

    //average length of string
    public static double calculateAverageStringLength(List<String> list1){
       return list1.stream().mapToInt(String::length).average().orElse(0.0);
    }

    //count the occurance of character in list of strings
  public static long countCharacterOccuranc(List<String> string1, char targetChar){
       return string1.stream().flatMapToInt(CharSequence::chars).filter(ch-> ch ==targetChar).count();
  }

  //factorial
    public static int calculateFactorial(int n){
        return IntStream.rangeClosed(1, n).reduce(1, (a,b)-> a *b);

    }

    //find the longest string
    public static String findLongestString(List<String> strings){
        Optional<String> longest=strings.stream().max(Comparator.comparingInt(String::length));
        return longest.orElse(null);
    }

    //convert all string to uppercase
    public static List<String> convertToUpperCase(List<String> strings){
        return strings.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    //counting frequency of word
    public static Map<String, Long> countWordFrequency(List<String> words){
        return words.stream().flatMap(line->List.of(line.split("\\s+")).stream()).collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

    }

    //find the sum of list of digits
    public static int calculateDigitSum(List<Integer> numbers){
        return numbers.stream().mapToInt(n-> String.valueOf(n).chars().map(Character::getNumericValue).sum()).sum();
    }


    //seperate odd and even numbers

    public static Map<Boolean, List<Integer>> seperateOddEven(List<Integer> numbers){
        return numbers.stream().collect(Collectors.partitioningBy(n-> n % 2 ==0));
    }

    //check two strings are anagrams
    public static boolean checkAnagram(String s1, String s2){
        char[] arr1=s1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[]arr2=s2.replaceAll("\\s", " ").toLowerCase().toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    //check two strings are palindrome
    public static boolean checkPalindrome(String s3){
        for(int i=0; i<s3.length()/2; i++){
            if(s3.charAt(i) != s3.charAt(s3.length()-i-1)){
                return false;
            }

        }
        return true;
    }

    //sort string according to their length
    public static List<String> sortStringByLength(List<String> str){
        return str.stream().sorted((s1, s2)->Integer.compare(s2.length(),s1.length())).toList();
    }

    //find most repeated element in array

    public static Map.Entry<Integer, Long> findMostRepeatedElement(int[] arr){
        return Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue()).orElseThrow(()->new IllegalArgumentException("array is empty"));
    }

    //find duplicate elements in array
    public static List<Integer> findDupliateElement(Integer[] array){
        Map<Integer, Long> countMap=Arrays.stream(array)
                .collect(Collectors.groupingBy(e->e, Collectors.counting()));
        return countMap.entrySet().stream()
                .filter(entry->entry.getValue() >1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    //find first repeated character in string
    public static char findFirstRepeatedCharacter(String str){
        HashSet<Character> set= new HashSet<>();

        return str.chars()
                .mapToObj(ch->(char)ch)
                .filter(ch-> !set.add(ch))
                .findFirst()
                .orElse('\0');
    }

    public static boolean containsString(List<String> list, String searchString) {
        return list.stream()
                .anyMatch(searchString::equals); // Using method reference
    }

    //find first non repeated character in string
    public static Character findFirstNonRepeatedChar(String str){
        return str.chars()
                .mapToObj(i->Character.toLowerCase((char) i))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry->entry.getValue() ==1L)
                .map(Map.Entry::getKey)
                .findFirst().get();
    }


    public static Optional<String> findFirstWordStartsWithLetter(List<String> words, char targetLetter) {
        return words.stream()
                .filter(word -> !word.isEmpty() && word.charAt(0) == targetLetter)
                .findFirst();
    }






















}
