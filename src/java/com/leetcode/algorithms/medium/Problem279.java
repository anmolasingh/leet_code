package com.leetcode.algorithms.medium;

/*
 * 279. Perfect Squares
 * https://leetcode.com/problems/perfect-squares/
 * Tags: Dynamic Programming
 * */

import java.util.Arrays;

public class Problem279 {

    //Bottom up approach
    public int numSquares(int n) {
        int[] cache = new int[n+1];
        Arrays.fill(cache, n);
        cache[0] = 0;
        cache[1] = 1;

        for(int i=2; i<=n; i++){
            for(int j=1; j<=Math.sqrt(i); j++){
                int square = j * j;
                cache[i] = Math.min(cache[i], 1 + cache[i - square]);
            }
        }
        return cache[n];
    }

    public static void main(String[] args) {
        System.out.println(new Problem279().numSquares(12));//3
        System.out.println(new Problem279().numSquares(13));//2
    }
}
