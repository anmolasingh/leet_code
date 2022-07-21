package com.leetcode.algorithms.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 * Tags: Array, Hash Map
 * */

public class Problem1 {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int i=0; i<nums.length; i++) {
      int diff = target - nums[i];
      if(map.containsKey(diff)) {
        return new int[]{i, map.get(diff)};
      }
      map.put(nums[i], i);
    }
    return new int[2];
  }

  public static void main(String[] args) {
    Problem1 problem1 = new Problem1();
    int nums[] = {2, 1, 5, 7};
    int target = 9;
    System.out.println(Arrays.toString(problem1.twoSum(nums, target)));
  }
}
