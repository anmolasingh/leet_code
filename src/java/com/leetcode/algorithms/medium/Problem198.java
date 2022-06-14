package com.leetcode.algorithms.medium;

/*
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/
 * Tags: Dynamic Programming
 * */

public class Problem198 {

    public int rob(int[] nums) {
        int l = nums.length;
        if(l==1){
            return nums[0];
        }
        int cache[] = new int[l];
        cache[l-1] = nums[l-1];
        cache[l-2] = Math.max(nums[l-1], nums[l-2]);
        for(int i= l-3; i>=0; i--) {
            cache[i] = Math.max(nums[i] + cache[i+2], cache[i+1]);
        }
        return cache[0];
    }

    public static void main(String[] args) {
        Problem198 problem198 = new Problem198();
        System.out.println(problem198.rob(new int[]{1,2,3,1}));
    }
}
