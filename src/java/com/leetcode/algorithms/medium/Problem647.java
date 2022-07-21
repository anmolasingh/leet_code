package com.leetcode.algorithms.medium;

/*
 * 647. Palindromic Substrings
 * https://leetcode.com/problems/palindromic-substrings/
 * Tags: String
 * */

public class Problem647 {

    public int countSubstrings(String s) {
        int res = 0;
        for(int i=0; i<s.length(); i++) {
            int l = i, r = i;
            while(l >= 0 && r < s.length()) {
                if(s.charAt(l) == s.charAt(r)) {
                    res += 1;
                    l--;
                    r++;
                } else {
                    break;
                }
            }

            l = i;
            r = i+1;
            while(l >= 0 && r < s.length()) {
                if(s.charAt(l) == s.charAt(r)) {
                    res += 1;
                    l--;
                    r++;
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Problem647().countSubstrings("abc"));//3
        System.out.println(new Problem647().countSubstrings("aaa"));//6
    }
}
