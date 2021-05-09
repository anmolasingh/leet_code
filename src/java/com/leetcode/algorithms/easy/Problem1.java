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
    int result[] = new int[2];
    Map<Integer,Integer> map = new HashMap<>();
    for(int i=0; i< nums.length; i++){
      int difference = target - nums[i];
      if(map.containsKey(difference)){
        result[0] = i;
        result[1] = map.get(difference);
        return result;
      }else{
        map.put(nums[i], i);
      }
    }
    return null;
  }

  public static void main(String[] args) {
    Problem1 problem1 = new Problem1();
    int nums[] = {2, 1, 5, 7};
    int target = 9;
    System.out.println(Arrays.toString(problem1.twoSum(nums, target)));
  }
}
