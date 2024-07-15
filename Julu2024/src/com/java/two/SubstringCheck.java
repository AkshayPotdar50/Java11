package com.java.two;

public class SubstringCheck {
    public static void main(String[] args) {
        // Example strings
        String mainString = "Hello, welcome to the world of Java!";
        String subString = "welcome";

        // Check if the subString is a substring of mainString
        boolean isSubstring = mainString.contains(subString);

        // Print the result
        if (isSubstring) {
            System.out.println("\"" + subString + "\" is a substring of \"" + mainString + "\".");
        } else {
            System.out.println("\"" + subString + "\" is not a substring of \"" + mainString + "\".");
        }
    }
}
