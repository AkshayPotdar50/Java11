package com.java.three;

public class ShuffleCheck {

    public static boolean isValidShuffle(String str1, String str2, String str3){
        if(str1.length() +str2.length() !=str3.length()){
            return false;
        }

        int i=0, j=0, k=0;

        while(k < str3.length()){

            if(j < str1.length() && str1.charAt(i) ==str3.charAt(k)){
                i++;
            }

            else if(j < str2.length() && str2.charAt(j) ==str3.charAt(k)){
                j++;
            }
            else {
                return false;
            }
            k++;
        }
        return true;

    }

    public static void main(String[] args) {
        String str1="abc";
        String str2="def";
        String str3="abcdef";

        if(isValidShuffle(str1, str2, str3)){
            System.out.println(str3+" is valid shuffle of "+str1+ " and"+str2);
        }else {
            System.out.println(str3+" is not  valid shuffle of "+str1+ " and"+str2);
        }
    }
}
