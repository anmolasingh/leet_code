package com.leetcode.algorithms;

/*
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 * Tags: Pointers, Two Pointers, Array, Sliding Window
 * */

public class Question11 {

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
    Question11 question11 = new Question11();
    System.out.println(question11.maxArea(height));
  }
}
