package com.leetcode.algorithms.medium;

import java.util.Arrays;

/*
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * Tags: Dynamic Programming
 * */

public class Problem300 {

    public int lengthOfLISIterative(int[] nums) {
        int[] cache = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            cache[i] = 1;
        }
        for(int i=nums.length-1;i>=0;i--) {
            for(int j=i+1;j<nums.length;j++) {
                if(nums[i] < nums[j]) {
                    cache[i] = Math.max(cache[i], 1 + cache[j]);
                }
            }
        }
        return Arrays.stream(cache).max().getAsInt();
    }

    int cache[];
    public int lengthOfLIS(int[] nums) {
        cache = new int[nums.length];
        Arrays.fill(cache, -1);
        int result = 0;
        for(int i=0; i<nums.length; i++) {
            result = Math.max(result, dfs(nums, i));
        }
        return result;
    }

    private int dfs(int[] nums, int i) {
        if(i == nums.length) {
            return 0;
        }

        if(cache[i] != -1) {
            return cache[i];
        }

        int result = 1;
        for(int j=i+1; j<nums.length; j++) {
            if(nums[j] > nums[i]) {
                result = Math.max(result, 1 + dfs(nums, j));
            }
        }
        cache[i] = result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem300().lengthOfLIS(new int[]{1,2,4,3}));//3
        System.out.println(new Problem300().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));//4
    }
}
