package com.leetcode.algorithms.medium;

import java.util.Arrays;

/*
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game/
 * Tags: Greedy, Dynamic Programming
 * */

public class Problem55 {

    //Greedy
    public boolean canJump(int[] nums) {
        if(nums.length == 1) {
            return true;
        }
        int goal = nums.length-1;
        int start = nums.length-2;
        while(start >= 0) {
            if(start + nums[start] >= goal) {
                int temp = start;
                goal = start;
                start = temp - 1;
            } else {
                start -= 1;
            }
        }
        return goal <= 0;
    }

    public boolean canJumpDP(int[] nums) {
        int cache[] = new int[nums.length];
        Arrays.fill(cache, -1);
        boolean result = dfs(nums, 0, cache);
        System.out.println(Arrays.toString(cache));
        return result;
    }

    private boolean dfs(int[] nums, int i, int[] cache) {
        if(i >= nums.length - 1) {
            return true;
        }
        if(cache[i] != -1) {
            System.out.println(i + ":" + cache[i]);
            return cache[i] == 1 ? true : false;
        }

        boolean result = false;
        for(int j=1; j<=nums[i];j++) {
            result = result || dfs(nums, i+j, cache);
        }
        cache[i] = result == true ? 1 : 0;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem55().canJump(new int[]{2,3,1,1,4}));//true
        System.out.println(new Problem55().canJump(new int[]{3,2,1,0,4}));//false
    }
}
