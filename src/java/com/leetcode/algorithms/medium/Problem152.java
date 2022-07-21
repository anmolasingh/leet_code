package com.leetcode.algorithms.medium;

/*
 * 152. Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray/
 * Tags: Array, Dynamic Programming
 * */

public class Problem152 {

    public int maxProduct(int[] nums) {
        int minPrefixSum = 1, maxPrefixSum = 1;
        int maxProduct = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            maxProduct = Math.max(maxProduct, nums[i]);
        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                minPrefixSum = 1;
                maxPrefixSum = 1;
            } else {
                int tempMinPrefixSum = minPrefixSum;
                minPrefixSum = Math.min(minPrefixSum * nums[i], Math.min(maxPrefixSum * nums[i], nums[i]));
                maxPrefixSum = Math.max(tempMinPrefixSum * nums[i], Math.max(maxPrefixSum * nums[i], nums[i]));
                maxProduct = Math.max(maxProduct, maxPrefixSum);
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(new Problem152().maxProduct(new int[]{2,3,-2,4}));//6
        System.out.println(new Problem152().maxProduct(new int[]{-2,0,-1}));//0
    }
}
