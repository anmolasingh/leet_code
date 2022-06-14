package com.leetcode.algorithms.medium;

/*
 * 424. Longest Repeating Character Replacement
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 * Tags: Array, Sliding Window
 * */

import java.util.HashMap;
import java.util.Map;

public class Problem424 {

    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        Map<Character, Integer> charCountMap = new HashMap<>();
        int leftIndex = 0;
        for(int i=0; i<s.length();i++){
            charCountMap.put(s.charAt(i), charCountMap.getOrDefault(s.charAt(i), 0) + 1);
            while(!isValidWindow(leftIndex, i, charCountMap, k)) {
                charCountMap.put(s.charAt(leftIndex), charCountMap.getOrDefault(s.charAt(leftIndex), 0) - 1);
                leftIndex += 1;
            }
            maxLength = Math.max(maxLength, i - leftIndex + 1);
        }
        return maxLength;
    }

    private boolean isValidWindow(int leftIndex, int rightIndex, Map<Character, Integer> charCountMap, int k) {
        return ((rightIndex - leftIndex + 1) - maxCharCount(charCountMap) <= k);
    }

    private int maxCharCount(Map<Character, Integer> charCountMap) {
        int max = 0;
        for (Map.Entry<Character, Integer> entry:
             charCountMap.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Problem424().characterReplacement("AAAA", 0));//4
        System.out.println(new Problem424().characterReplacement("ABAB", 2));//4
        System.out.println(new Problem424().characterReplacement("ABAB", 1));//3
        System.out.println(new Problem424().characterReplacement("AABABBA", 1));//4
    }
}
