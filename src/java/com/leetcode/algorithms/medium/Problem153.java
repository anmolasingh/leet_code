package com.leetcode.algorithms.medium;

/*
 * 153. Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * Tags: Array
 * */

public class Problem153 {

    public int findMin(int[] nums) {
        int result = Integer.MAX_VALUE;
        int l=0, r=nums.length-1;
        while(l <= r) {
            if(nums[l] < nums[r]) {
                result = Math.min(result, nums[l]);
                break;
            }

            int m = (l + r)/2;
            result = Math.min(result, nums[m]);
            if(nums[m] >= nums[l]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem153().findMin(new int[]{3,4,5,1,2}));//1
        System.out.println(new Problem153().findMin(new int[]{4,5,6,7,0,1,2}));//0
        System.out.println(new Problem153().findMin(new int[]{11,13,15,17}));//11
    }
}
