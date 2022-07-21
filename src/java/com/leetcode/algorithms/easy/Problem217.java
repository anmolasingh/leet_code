package com.leetcode.algorithms.easy;

import java.util.HashSet;
import java.util.Set;

/*
 * 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 * Tags: Array, Hash Set
 * */

public class Problem217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length;  i++){
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Problem217().containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));//true
    }
}
