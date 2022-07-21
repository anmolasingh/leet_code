package com.leetcode.algorithms.medium;

/*
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * Tags: Array
 * */

public class Problem33 {

    public int search(int[] nums, int target) {
        int l=0, r=nums.length-1;
        while(l <= r) {
            int m = (l + r)/2;
            if(nums[m] == target) {
                return m;
            }

            if(nums[l] <= nums[m]) {
                if (target > nums[m] || target < nums[l]) {
                    l = m+1;
                } else {
                    r = m-1;
                }
            } else {
                if(target < nums[m] || target > nums[r]) {
                    r = m-1;
                } else {
                    l = m+1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Problem33().search(new int[]{4,5,6,7,0,1,2}, 0));//4
        System.out.println(new Problem33().search(new int[]{4,5,6,7,0,1,2}, 3));//-1
        System.out.println(new Problem33().search(new int[]{1}, 0));//-1
    }
}
