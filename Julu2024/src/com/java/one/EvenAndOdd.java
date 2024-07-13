package com.java.one;

public class EvenAndOdd {
    public static void main(String[] args) {
        int[] arr={1, 2, 3,4, 5, 6, 7, 8, 9, 10,11};
        int count1=findEvenCount(arr);
        int count2=findOddCount(arr);
        System.out.println("even"+count1);
        System.out.println("odd"+count2);
    }


    public static int findEvenCount(int[] arr){
        int count=0;
        for(int num:arr){
            if(num %2==0){
                count++;
            }
        }
        return count;
    }

    public static int findOddCount(int[] arr){
        int count=0;
        for(int num:arr){
            if(num%2 !=0){
                count++;
            }
        }
        return count;
    }
}
