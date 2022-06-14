package com.leetcode.algorithms.medium;

/*
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/
 * Tags: Dynamic Programming
 * */

import java.util.Arrays;

public class Problem322 {

    public int coinChange(int[] coins, int amount) {
        int cache[] = new int[amount+1];
        Arrays.fill(cache, Integer.MAX_VALUE);
        cache[0] = 0;
        for(int i=1; i<=amount; i++){
            int minChange = Integer.MAX_VALUE;
            for(int j=0; j<coins.length; j++){
                int reducedAmount = i - coins[j];
                if(reducedAmount >= 0 && cache[reducedAmount] != Integer.MAX_VALUE) {
                    minChange = Math.min(minChange, cache[reducedAmount] + 1);
                }
            }
            cache[i] = minChange;
        }
        //System.out.println(Arrays.toString(cache));
        return cache[amount] == Integer.MAX_VALUE ? -1: cache[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Problem322().coinChange(new int[]{1,2,5}, 11));//3
        System.out.println(new Problem322().coinChange(new int[]{3,5}, 11));//3
        System.out.println(new Problem322().coinChange(new int[]{2}, 3));//-1
        System.out.println(new Problem322().coinChange(new int[]{1}, 0));//0
    }
}
