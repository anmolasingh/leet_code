package com.leetcode.algorithms.medium;

import java.util.Arrays;

/*
 * 189. Rotate Array
 * https://leetcode.com/problems/rotate-array/
 * Tags: Array
 * */

public class Problem189 {

  public void rotate(int[] nums, int k) {
    for(int i=0; i<k; ++i) {
      int temp = nums[0];
      for(int j=1;j<=nums.length;++j) {
        int pos = j;
        if(pos > nums.length - 1) {
          pos = 0;
        }
        int temp1 = nums[pos];
        nums[pos] = temp;
        temp = temp1;
      }
    }
  }

  public static void main(String[] args) {
    Problem189 problem189 = new Problem189();
    int[] nums = {1,2,3,4,5,6,7};
    problem189.rotate(nums, 3);
    System.out.println(Arrays.toString(nums));
  }

}
