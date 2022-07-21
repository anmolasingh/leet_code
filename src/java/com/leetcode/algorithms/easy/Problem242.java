package com.leetcode.algorithms.easy;

import java.util.*;

/*
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 * Tags: String
 * */

public class Problem242 {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> countMap = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);

            ch = t.charAt(i);
            countMap.put(ch, countMap.getOrDefault(ch, 0) - 1);
        }

        for (Map.Entry<Character, Integer> entry:countMap.entrySet()) {
            if(entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem242().isAnagram("anagram", "anagram"));//true
        System.out.println(new Problem242().isAnagram("rat", "car"));//false
    }
}
