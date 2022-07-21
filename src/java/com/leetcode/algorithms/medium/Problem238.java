package com.leetcode.algorithms.medium;

/*
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 * Tags: Array
 * */

import java.util.Arrays;

public class Problem238 {

    public int[] productExceptSelf(int[] nums) {
        int result[] = new int[nums.length];
        int prefix = 1, postfix = 1;

        //Calculate prefix
        for(int i=0; i<nums.length; i++) {
            result[i] = prefix;
            prefix*= nums[i];
        }
        //Calculate postfix
        for(int i=nums.length-1; i>=0; i--) {
            result[i] *= postfix;
            postfix*= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Problem238().productExceptSelf(new int[]{1,2,3,4})));//[24,12,8,6]
        System.out.println(Arrays.toString(new Problem238().productExceptSelf(new int[]{-1,1,0,-3,3})));//[0,0,9,0,0]
    }
}
