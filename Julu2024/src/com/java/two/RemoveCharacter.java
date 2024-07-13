package com.java.two;

import java.util.stream.Collectors;

public class RemoveCharacter {
    public static void main(String[] args) {
        String input="you are a dirty dancer";

        String noChar=removeChar(input,'a');
        String noVowel=removeVowel(input);
        String noConsonant=removeConsonant(input);

        System.out.println(noChar+" "+noConsonant+" "+noVowel);
    }

    public static String removeChar(String str, char ch){
        return str.replaceAll(Character.toString(ch), "");
    }

    //REMOVE VOWELS
    public static String removeConsonant(String str){
        return str.chars()
                .filter(c->"AEIOUaeiou".contains(Character.toString(c)))
                .mapToObj(c->Character.toString((char)c))
                .collect(Collectors.joining());
    }

    public static String removeVowel(String str){
        return str.chars()
                .filter(c->! "AEIOUaeiou".contains(Character.toString(c)))
                .mapToObj(c->Character.toString((char)c))
                .collect(Collectors.joining());
    }


}
