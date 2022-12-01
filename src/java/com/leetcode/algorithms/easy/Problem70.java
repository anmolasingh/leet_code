package com.leetcode.algorithms.easy;

/*
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 * Tags: Dynamic Programming
 * */

public class Problem70 {

    public int climbStairs(int n) {
        if(n==1) {
            return 1;
        }
        int cache[] = new int[n+1];
        cache[1] = 1;
        cache[2] = 2;
        for(int i=3; i<=n; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n];
    }

    public static void main(String[] args) {
        System.out.println(new Problem70().climbStairs(2));//2
        System.out.println(new Problem70().climbStairs(5));//8
    }
}
