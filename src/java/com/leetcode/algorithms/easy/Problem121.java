package com.leetcode.algorithms.easy;

/*
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Tags: Pointers, Two Pointers, Array, Sliding Window
 * */

public class Problem121 {

  public int maxProfit(int[] prices) {
    if(prices.length == 1) {
      return 0;
    }
    int left = 0;
    int right = 1;
    int max = 0;

    while(right < prices.length) {
      while(prices[left] > prices[right]) {
        left++;
      }
      max = Math.max(max, prices[right] - prices[left]);
      right++;
    }
    return max;
  }

  public static void main(String[] args) {
    Problem121 problem121 = new Problem121();
    int arr[] = {7, 5, 3, 6, 1, 3};
    System.out.println(problem121.maxProfit(arr));
  }
}
