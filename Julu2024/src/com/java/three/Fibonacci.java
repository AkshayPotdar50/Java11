package com.java.three;

public class Fibonacci {

    public static void main(String[] args) {
        int N=10;
        int num1=0;
        int num2=1;

        System.out.println("Fibonacci series N="+N);
        System.out.println(num1+" "+num2);
        int i=2;
        while(i<=N){
            i++;
            int temp=num1+num2;
            num1=num2;
            num2=temp;
            System.out.println(" "+num2);
        }
    }

}
