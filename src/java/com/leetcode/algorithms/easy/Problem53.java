package com.leetcode.algorithms.easy;

/*
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/
 * Tags: Array, Kadane Algorithm
 */

public class Problem53 {

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = 0;

        for (int n: nums) {
            if(currSum < 0) {
                currSum = 0;
            }
            currSum += n;
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new Problem53().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));//6
        System.out.println(new Problem53().maxSubArray(new int[]{1}));//1
        System.out.println(new Problem53().maxSubArray(new int[]{5,4,-1,7,8}));//23
    }
}
