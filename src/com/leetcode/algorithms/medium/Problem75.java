package com.leetcode.algorithms.medium;

/*
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/
 * Tags: Pointers, Two Pointers, Array
 * */

import java.util.Arrays;

public class Problem75 {

    private void sortColors(int[] nums) {
        if(nums.length < 2){
            return;
        }

        int start = 0, end = nums.length - 1, index = 0;
        while(index <= end && start < end){
            if(nums[index] == 0){
                nums[index] = nums[start];
                nums[start] = 0;
                start++;
                index++;
            }else if(nums[index] == 2){
                nums[index] = nums[end];
                nums[end] = 2;
                end--;
            }else{
                //When the value is 1
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = {2,0,2,1,1,0};
        Problem75 problem75 = new Problem75();
        problem75.sortColors(nums);
        Arrays.stream(nums).forEach(record -> System.out.print(record + " "));
    }
}
