package com.leetcode.algorithms.medium;

/*
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 * Tags: Pointers, Two Pointers, Array, Sliding Window
 * */

public class Problem11 {

  public int maxArea(int[] height) {
    int result = 0;

    int l=0, r=height.length-1;
    while(l < r) {
      int currArea = Math.min(height[l], height[r]) * (r - l);
      result = Math.max(result, currArea);
      if(height[l] < height[r]) {
        l++;
      } else {
        r--;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    Problem11 problem11 = new Problem11();
    System.out.println(problem11.maxArea(height));
  }
}
