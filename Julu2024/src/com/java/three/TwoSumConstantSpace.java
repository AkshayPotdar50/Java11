package com.java.three;

import java.util.Arrays;

public class TwoSumConstantSpace {
    public static int[] twoSum(int[] nums, int target){
        Arrays.sort(nums);

        int left =0;
        int right=nums.length-1;

        while(left < right){
            int sum=nums[left]+nums[right];
            if(sum ==target){
                return  new int[]{nums[left], nums[right]};
            }else if(sum <target){
                left++;
            }else{
                right--;
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr={2, 7, 11, 8, 45, 26};
        int target=15;
        int[] result=twoSum(arr, target);

        if(result.length ==2){
            System.out.println("pair found "+result[0]+" ,"+result[1]);
        }else {
            System.out.println("no pair found");
        }
    }
}
