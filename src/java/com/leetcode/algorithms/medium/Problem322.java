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
        for(int i=1; i<=amount;i++) {
            for(int j=0;j<coins.length;j++) {
                int ra = i - coins[j];
                if(ra == 0) {
                    cache[i] = 1;
                } else if(ra > 0) {
                    if(cache[ra] != Integer.MAX_VALUE) {
                        cache[i] = Math.min(cache[i], cache[ra] + 1);
                    }
                }
            }
        }
        return cache[amount] == Integer.MAX_VALUE ? -1 : cache[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Problem322().coinChange(new int[]{1,2,5}, 11));//3
        System.out.println(new Problem322().coinChange(new int[]{3,5}, 11));//3
        System.out.println(new Problem322().coinChange(new int[]{2}, 3));//-1
        System.out.println(new Problem322().coinChange(new int[]{1}, 0));//0
    }
}
