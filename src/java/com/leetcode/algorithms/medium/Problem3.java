package com.leetcode.algorithms.medium;

import java.util.HashSet;
import java.util.Set;

/*
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Tags: Pointers, Two Pointers, Array, Sliding Window
 * */

public class Problem3 {

  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    Set<Character> set = new HashSet<>();
    int maxLength = 0, indexLeft = 0, indexRight = 0;
    while (indexRight < s.length()) {
      if (!set.contains(s.charAt(indexRight))) {
        set.add(s.charAt(indexRight));
        indexRight++;
        maxLength = Math.max(maxLength, set.size());
      } else {
        set.remove(s.charAt(indexLeft));
        indexLeft++;
      }
    }
    return maxLength;
  }

  public static void main(String[] args) {
    Problem3 problem3 = new Problem3();
    System.out.println(problem3.lengthOfLongestSubstring("abcabablubcbb"));
  }
}
