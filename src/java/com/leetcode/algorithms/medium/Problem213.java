package com.leetcode.algorithms.medium;

/*
 * 213. House Robber II
 * https://leetcode.com/problems/house-robber-ii/
 * Tags: Dynamic Programming
 * */

public class Problem213 {

    public int rob(int[] nums) {
        int result = 0;
        int l = nums.length;
        if(l==1){
            return nums[0];
        }
        if(l==2){
            return Math.max(nums[0], nums[1]);
        }
        int cache[] = new int[l];
        cache[l-1] = nums[l-1];
        cache[l-2] = Math.max(nums[l-1], nums[l-2]);
        for(int i= l-3; i>=1; i--) {
            cache[i] = Math.max(nums[i] + cache[i+2], cache[i+1]);
        }
        result = cache[1];

        cache = new int[l];
        cache[l-2] = nums[l-2];
        cache[l-3] = Math.max(nums[l-2], nums[l-3]);
        for(int i= l-4; i>=0; i--) {
            cache[i] = Math.max(nums[i] + cache[i+2], cache[i+1]);
        }
        result = Math.max(result, cache[0]);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem213().rob(new int[]{2,3,2}));//3
    }
}
