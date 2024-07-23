package com.java.two;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringOperations {
    public static void main(String[] args) {
        // Basic String Operations

        // 1. Concatenation
        String s1 = "Hello";
        String s2 = "World";
        String concatenated = s1 + " " + s2; // Using + operator
        String concatenated2 = s1.concat(" ").concat(s2); // Using concat() method
        System.out.println("Concatenated: " + concatenated);
        System.out.println("Concatenated2: " + concatenated2);

        // 2. Comparison
        String s3 = "Java";
        String s4 = "java";
        boolean equals = s3.equals(s4); // Using equals()
        boolean equalsIgnoreCase = s3.equalsIgnoreCase(s4); // Using equalsIgnoreCase()
        int compareTo = s3.compareTo(s4); // Using compareTo()
        System.out.println("Equals: " + equals);
        System.out.println("EqualsIgnoreCase: " + equalsIgnoreCase);
        System.out.println("CompareTo: " + compareTo);

        // 3. Substrings
        String s5 = "HelloJavaWorld";
        String substring = s5.substring(5, 9); // Using substring() method
        System.out.println("Substring: " + substring);

        // 4. Length
        int length = s5.length(); // Using length() method
        System.out.println("Length: " + length);

        // 5. Character Extraction
        char charAt = s5.charAt(0); // Using charAt() method
        System.out.println("CharAt: " + charAt);

        // Using Stream API to combine and demonstrate multiple strings
        List<String> words = Arrays.asList("Hello", "Java", "World");
        String joined = words.stream().collect(Collectors.joining(" ")); // Joining strings using Stream API
        System.out.println("Joined: " + joined);


        // Using StringBuilder for efficient string manipulation
        StringBuilder sb = new StringBuilder();

        // Appending and Modifying
        sb.append("Hello"); // Appending
        sb.append(" ");
        sb.append("World");
        System.out.println("StringBuilder after append: " + sb.toString());

        sb.insert(5, " Java"); // Inserting
        System.out.println("StringBuilder after insert: " + sb.toString());

        sb.delete(5, 10); // Deleting
        System.out.println("StringBuilder after delete: " + sb.toString());

        sb.reverse(); // Reversing
        System.out.println("StringBuilder after reverse: " + sb.toString());

        // Using StringBuffer for thread-safe string manipulation
        StringBuffer sbf = new StringBuffer();

        // Appending and Modifying
        sbf.append("Hello"); // Appending
        sbf.append(" ");
        sbf.append("World");
        System.out.println("StringBuffer after append: " + sbf.toString());

        sbf.insert(5, " Java"); // Inserting
        System.out.println("StringBuffer after insert: " + sbf.toString());

        sbf.delete(5, 10); // Deleting
        System.out.println("StringBuffer after delete: " + sbf.toString());

        sbf.reverse(); // Reversing
        System.out.println("StringBuffer after reverse: " + sbf.toString());

        // Performance Note:
        // StringBuilder is faster as it is not synchronized.
        // StringBuffer is thread-safe but slower due to synchronization.


        // 3. Regular Expressions

        // Pattern Matching
        String text = "Hello123World";
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Found a match: " + matcher.group());
        }

        // Replacing Patterns
        String replaced = text.replaceAll("\\d+", "-");
        System.out.println("After replaceAll: " + replaced);

        String replacedFirst = text.replaceFirst("\\d", "-");
        System.out.println("After replaceFirst: " + replacedFirst);

        // Splitting Strings
        String sentence = "This is a test sentence.";
        String[] words1 = sentence.split(" ");
        System.out.println("Words after split:");
        for (String word : words1) {
            System.out.println(word);
        }

        // 4. String Methods Enhancements (Java SE 7 - 8)

        // String Joiner
        StringJoiner joiner = new StringJoiner(", ");
        joiner.add("Apple");
        joiner.add("Banana");
        joiner.add("Cherry");
        String joined1 = joiner.toString();
        System.out.println("Joined with StringJoiner: " + joined1);

        // String.join()
        String joinedWithJoin = String.join(", ", "Apple", "Banana", "Cherry");
        System.out.println("Joined with String.join(): " + joinedWithJoin);

        // Lambda Expressions and Streams
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");
        String joinedWithStreams = fruits.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));
        System.out.println("Joined with Streams: " + joinedWithStreams);
    }
}

