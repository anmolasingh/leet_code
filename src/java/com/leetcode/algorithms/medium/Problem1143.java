package com.leetcode.algorithms.medium;

/*
 * 1143. Longest Common Subsequence
 * https://leetcode.com/problems/longest-common-subsequence/
 * Tags: Dynamic Programming
 * */

public class Problem1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int cache[][] = new int[text1.length() + 1][text2.length() + 1];
        for(int i=text1.length() - 1;i>=0;i--){
            for(int j=text2.length() - 1;j>=0;j--){
                if(text1.charAt(i) == text2.charAt(j)) {
                    cache[i][j] = 1 + cache[i+1][j+1];
                }else {
                    cache[i][j] = Math.max(cache[i+1][j], cache[i][j+1]);
                }
            }
        }
        return cache[0][0];
    }

    public int longestCommonSubsequenceDFS(String text1, String text2) {
        int cache[][] = new int[text1.length() + 1][text2.length() + 1];
        return dfs(text1, text2, cache, 0, 0);
    }

    private int dfs(String text1, String text2, int[][] cache, int i, int j) {
        if(i >= text1.length() || j >= text2.length()) {
            return 0;
        }
        if(cache[i][j] != 0) {
            return cache[i][j];
        }
        if(text1.charAt(i) == text2.charAt(j)) {
            cache[i][j] = 1 + dfs(text1, text2, cache, i+1, j+1);
        } else{
            cache[i][j] = Math.max(dfs(text1, text2, cache, i+1, j), dfs(text1, text2, cache, i, j+1));
        }
        return cache[i][j];
    }

    public static void main(String[] args) {
        System.out.println(new Problem1143().longestCommonSubsequence("abcde", "ace"));//3
        System.out.println(new Problem1143().longestCommonSubsequence("abc", "def"));//0
    }
}
