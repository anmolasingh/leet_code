package com.leetcode.algorithms.medium;

/*
 * 438. Find All Anagrams in a String
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * Tags: Array, Sliding Window
 * */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length() < p.length()) {
            return result;
        }

        Map<Character, Integer> pCharCountMap = new HashMap<>();
        for(int i=0; i<p.length(); i++) {
            pCharCountMap.put(p.charAt(i), pCharCountMap.getOrDefault(p.charAt(i), 0) + 1);
        }

        Map<Character, Integer> charCountMap = new HashMap<>();
        for(int i=0; i<p.length()-1; i++) {
            charCountMap.put(s.charAt(i), charCountMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int l=0; l<=s.length()-p.length();l++) {

            //Add r index value
            int r = l + p.length() - 1;
            charCountMap.put(s.charAt(r), charCountMap.getOrDefault(s.charAt(r), 0) + 1);

            if(isValidWindow(charCountMap, pCharCountMap)) {
                result.add(l);
            }

            //Reduce/remove l index value
            int removeCharVal = charCountMap.get(s.charAt(l)) - 1;
            if(removeCharVal == 0) {
                charCountMap.remove(s.charAt(l));
            } else {
                charCountMap.put(s.charAt(l), removeCharVal);
            }

        }

        return result;
    }

    private boolean isValidWindow(Map<Character, Integer> charCountMap, Map<Character, Integer> pCharCountMap) {
        return charCountMap.equals(pCharCountMap);
    }

    public static void main(String[] args) {
        System.out.println(new Problem438().findAnagrams("cbaebabacd","abc"));//[0,6]
        System.out.println(new Problem438().findAnagrams("abab","ab"));//[0,1,2]
        System.out.println(new Problem438().findAnagrams("baa","aa"));//[1]
    }
}
