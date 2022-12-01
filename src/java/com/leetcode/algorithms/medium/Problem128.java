package com.leetcode.algorithms.medium;

import java.util.*;

/*
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * Tags: Array, Hash Set
 * */

public class Problem128 {

    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        for(int i=0; i<nums.length; i++) {
            if(set.contains(nums[i]) && !set.contains(nums[i] - 1)) {
                int currLength = expandSequence(nums[i], set);
                maxLength = Math.max(maxLength, currLength);
            }
        }
        return maxLength;
    }

    private int expandSequence(int seq, Set<Integer> set) {
        int result = 0;
        while(set.contains(seq)) {
            seq++;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem128().longestConsecutive(new int[]{100,4,200,1,3,2}));//4
        System.out.println(new Problem128().longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));//9
    }
}
