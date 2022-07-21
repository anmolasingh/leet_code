package com.leetcode.algorithms.medium;

/*
 * 209. Minimum Size Subarray Sum
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * Tags: Array, Sliding Window
 * */

public class Problem209 {

    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0;
        int currSum = 0, minLength = Integer.MAX_VALUE;
        while(r < nums.length) {
            currSum += nums[r];

            while(currSum >= target && l<=r) {
                int currLength = r-l+1;
                if (currLength < minLength) {
                    minLength = r-l+1;
                }
                currSum -= nums[l];
                l++;
            }
            r++;
        }
        return minLength == Integer.MAX_VALUE ? 0: minLength;
    }

    public static void main(String[] args) {
        System.out.println(new Problem209().minSubArrayLen(7, new int[]{2,3,1,2,4,3}));//2
        System.out.println(new Problem209().minSubArrayLen(4, new int[]{1,4,4}));//1
        System.out.println(new Problem209().minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));//0
    }
}
