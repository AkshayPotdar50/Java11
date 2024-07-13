package com.java.one;

public class CountingPrime {
    public static void main(String[] args) {
        int[] arr={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int count =countPrime(arr);
        System.out.println("number of prime numbers:"+count);
    }

    

    public static int countPrime(int[] arr){

        int count =0;
        for(int num:arr){
            if(isPrime(num)){
                count++;
            }
        }
        return count;
    }


    public static boolean isPrime(int num){
        if(num <= 1){
            return false;
        }
        if(num <=3){
            return true;
        }
        if(num %2 ==0 || num%3 ==0){
            return false;
        }

        for(int i=5; i*i<num; i+=6){
            if(num %i ==0 || num %(i+2)==0){
                return false;
            }
        }
        return true;
    }
}
