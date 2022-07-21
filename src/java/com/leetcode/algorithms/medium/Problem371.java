package com.leetcode.algorithms.medium;

/*
 * 371. Sum of Two Integers
 * https://leetcode.com/problems/sum-of-two-integers/
 * Tags: Binary, Bit Manipulation
 * */

public class Problem371 {

    public int getSum(int a, int b) {
        while(b != 0) {
            int temp = (a & b) << 1;//carry
            a = a ^ b; //XOR
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Problem371().getSum(1,2));//3
        System.out.println(new Problem371().getSum(2,3));//5
    }
}
