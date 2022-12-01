package com.leetcode.algorithms.medium;

/*
 * 647. Palindromic Substrings
 * https://leetcode.com/problems/palindromic-substrings/
 * Tags: String
 * */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        System.out.println(new Problem647().countSubstrings("bcaa"));//5
        System.out.println(new Problem647().countSubstrings("caab"));//5
        System.out.println(new Problem647().countSubstrings("abcaab"));//10
    }
}
