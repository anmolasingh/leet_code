package com.leetcode.algorithms.hard;

import java.util.*;

/*
 * 76. Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/
 * Tags: String, Sliding Window
 * */

public class Problem76 {

    public String minWindow(String s, String t) {
        int minLength = Integer.MAX_VALUE;
        int resultStart = -1, resultEnd = -1;
        Map<Character, Integer> want = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            want.put(ch, 1 + want.getOrDefault(ch, 0));
        }

        int start = 0, end = 0;
        while(end < s.length()) {
            char ch = s.charAt(end);
            window.put(ch, 1 + window.getOrDefault(ch, 0));
            while(isValid(window, want) && start <= end) {
                if(end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    resultStart = start;
                    resultEnd = end;
                }
                int value = window.getOrDefault(s.charAt(start), 0);
                if(value > 0) {
                    window.put(s.charAt(start), value-1);
                }
                start++;
            }
            end++;
        }

        if(resultStart != -1) {
            return s.substring(resultStart, resultEnd+1);
        } else {
            return "";
        }
    }

    private boolean isValid(Map<Character, Integer> window, Map<Character, Integer> want) {
        for(Character ch : want.keySet()) {
            if(window.getOrDefault(ch, 0) < want.get(ch)) {
                return false;
            }
        }
        return true;
    }

    //O(n) - Not working for a few cases
    int have, want;
    public String minWindow1(String s, String t) {
        int minLength = Integer.MAX_VALUE;
        int resultStart = -1, resultEnd = -1;
        have = 0;
        want = 0;
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            tMap.put(ch, 1 + tMap.getOrDefault(ch, 0));
        }
        want = tMap.keySet().size();

        int start = 0, end = 0;
        while(end < s.length()) {
            char ch = s.charAt(end);
            window.put(ch, 1 + window.getOrDefault(ch, 0));

            if(tMap.containsKey(ch) && window.getOrDefault(ch, 0) == tMap.get(ch)) {
                have++;
            }

            while(have == want) {
                if(end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    resultStart = start;
                    resultEnd = end;
                }
                int value = window.getOrDefault(s.charAt(start), 0);
                if(value > 0) {
                    window.put(s.charAt(start), value-1);
                }
                char sch = s.charAt(start);
                if(tMap.containsKey(sch) && window.getOrDefault(sch, 0) < tMap.get(sch)) {
                    have--;
                }
                start++;
            }
            end++;
        }

        if(resultStart != -1) {
            return s.substring(resultStart, resultEnd+1);
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem76().minWindow("ADOBECODEBANC", "ABC"));//BANC
    }
}
