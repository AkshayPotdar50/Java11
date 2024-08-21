package com.java.java8;

public class AramStrongNumber {
    public static boolean isAramstrong(int num){
        String numberStr=String.valueOf(num);
        int numberOfDigit=numberStr.length();

        int sum=numberStr.chars()
                .map(Character::getNumericValue)
                .map(digit->(int)Math.pow(digit, numberOfDigit))
                .sum();
        return sum == num;
    }

    public static void main(String[] args) {
        int number=153;
        System.out.println(isAramstrong(number));
    }
}