package com.leetcode.algorithms.medium;

/*
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 * Tags: Pointers, Two Pointers, Array, Sliding Window
 * */

public class Problem11 {

  public int maxArea(int[] height) {
    int maxArea = 0, aPointer = 0, bPointer = height.length - 1;

    while (aPointer < bPointer) {
      if (height[aPointer] < height[bPointer]) {
        maxArea = Math.max(maxArea, height[aPointer] * (bPointer - aPointer));
        aPointer++;
      } else {
        maxArea = Math.max(maxArea, height[bPointer] * (bPointer - aPointer));
        bPointer--;
      }
    }

    return maxArea;
  }

  public static void main(String[] args) {
    int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    Problem11 problem11 = new Problem11();
    System.out.println(problem11.maxArea(height));
  }
}
