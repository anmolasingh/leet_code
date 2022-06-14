package com.leetcode.algorithms.easy;

/*
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Tags: Pointers, Two Pointers, Array, Sliding Window
 * */

public class Problem121 {

  public int maxProfit(int[] prices) {
    if(prices == null || prices.length == 0){
      return 0;
    }

    int low = prices[0];

    int maxProfit = 0;

    for(int i=1; i<prices.length; ++i) {
      if(prices[i] < low) {
        low = prices[i];
      } else {
        int currentProfit = prices[i] - low;
        if(currentProfit > maxProfit) {
          maxProfit = currentProfit;
        }
      }
    }

    return maxProfit;
  }

  public static void main(String[] args) {
    Problem121 problem121 = new Problem121();
    int arr[] = {7, 5, 3, 6, 1, 3};
    System.out.println(problem121.maxProfit(arr));
  }
}
