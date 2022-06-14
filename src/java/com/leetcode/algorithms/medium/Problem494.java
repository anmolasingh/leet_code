package com.leetcode.algorithms.medium;

/*
 * 494. Target Sum
 * https://leetcode.com/problems/target-sum/
 * Tags: Dynamic Programming
 * */

import java.util.Arrays;

public class Problem494 {

    private int[][] cache;
    int total;

    public int findTargetSumWays(int[] nums, int target) {
        total = Arrays.stream(nums).sum();
        cache = new int[nums.length][total * 2 + 1];
        for(int i=0; i<nums.length;i++){
            Arrays.fill(cache[i], Integer.MAX_VALUE);
        }
        return dfs(nums, target, 0, 0);
    }

    private int dfs(int[] nums, int target, int index, int currTotal) {
        if(index == nums.length) {
            if (currTotal == target) {
                return 1;
            } else {
                return 0;
            }
        }

        if(cache[index][total + currTotal] != Integer.MAX_VALUE) {
            return cache[index][total + currTotal];
        }

        int noOfExpressions1 = dfs(nums, target, index+1, currTotal + nums[index]);
        int noOfExpressions2 = dfs(nums, target, index+1, currTotal - nums[index]);
        cache[index][total + currTotal] = noOfExpressions1 + noOfExpressions2;
        return cache[index][total + currTotal];
    }

    public static void main(String[] args) {
        Problem494 problem494 = new Problem494();
        System.out.println(problem494.findTargetSumWays(new int[]{1,1,1,1,1}, 3));//5
        System.out.println(problem494.findTargetSumWays(new int[]{1}, 1));//1
    }
}