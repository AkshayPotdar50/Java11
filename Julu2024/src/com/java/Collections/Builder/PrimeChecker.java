package com.java.Collections.Builder;

import java.util.Scanner;
import java.util.stream.IntStream;

public class PrimeChecker {


    private static boolean isPrime(int number){
        if(number <2){
            return false;
        }
        return IntStream.rangeClosed(2, (int)Math.sqrt(number))
                .noneMatch(i-> number % i ==0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter a digit to print prime numbers");
        int n= scanner.nextInt();
        System.out.println("print prime numbers between 1  and "+n);
       int sum= IntStream.rangeClosed(1, n)
                .filter(PrimeChecker::isPrime)
                .sum();
        System.out.println("sum of prime numbers is"+sum);
    }
}
