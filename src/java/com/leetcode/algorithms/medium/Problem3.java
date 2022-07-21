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
    Set<Character> set = new HashSet<>();
    int l=0, r=0, maxLength=0;
    while(r < s.length()) {
      if(!set.contains(s.charAt(r))) {
        set.add(s.charAt(r));
        maxLength = Math.max(maxLength, set.size());
        r++;
      } else {
        set.remove(s.charAt(l));
        l++;
      }
    }
    return maxLength;
  }

  public static void main(String[] args) {
    Problem3 problem3 = new Problem3();
    System.out.println(problem3.lengthOfLongestSubstring("abcabcbb"));//3
  }
}
