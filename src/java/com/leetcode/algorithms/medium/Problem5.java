package com.leetcode.algorithms.medium;

/*
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 * Tags: Dynamic Programming, String
 * */

public class Problem5 {

    boolean[][] cache;

    public String longestPalindrome(String s) {
        cache = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            cache[i][i] = true;
        }

        String longestStr = "" + s.charAt(0);
        int maxLength = 0;
        for (int i = 2; i <= s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                if(isPalindrome(j, j + i - 1, s)) {
                    cache[j][j+ i - 1] = true;
                    //System.out.println(s.substring(j, j+i));
                    if(i > maxLength) {
                        longestStr = s.substring(j, j+i);
                        maxLength = i;
                    }
                }
            }
        }
        return longestStr;
    }

    private boolean isPalindrome(int start, int end, String s) {
        //System.out.println(start + "/" + end);
        if(s.charAt(start) == s.charAt(end) && ((end - start == 1) || cache[start+1][end-1])){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Problem5 p5 = new Problem5();
        System.out.println(p5.longestPalindrome("ffffffffffff"));
    }
}
