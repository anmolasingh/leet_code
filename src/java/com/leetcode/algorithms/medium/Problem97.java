package com.leetcode.algorithms.medium;

/*
 * 97. Interleaving String
 * https://leetcode.com/problems/interleaving-string/
 * Tags: Dynamic Programming
 * */

public class Problem97 {

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return dfs(s1, s2, s3, 0, 0, 0, new int[s1.length()+1][s2.length()+1]);
    }

    private boolean dfs(String s1, String s2, String s3, int i, int j, int k, int[][] cache) {
        //System.out.println(i + ":" + j + ":" + k);
        if (i + j == s3.length()) {
            return true;
        } else if (i >= s1.length() && j >= s2.length()) {
            return false;
        }

        if(cache[i][j] != 0){
            return cache[i][j] == 1 ? true : false;
        }

        boolean isInterleaving = false;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            isInterleaving = isInterleaving || dfs(s1, s2, s3, i+1, j, k+1, cache);
        }
        if(j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            isInterleaving = isInterleaving || dfs(s1, s2, s3, i, j+1, k+1, cache);
        }
        cache[i][j] = isInterleaving ? 1 : -1;
        return isInterleaving;
    }

    public static void main(String[] args) {
        System.out.println(new Problem97().isInterleave("aabcc", "dbbca", "aadbbcbcac"));//true
        System.out.println(new Problem97().isInterleave("aabcc", "dbbc", "aadbbcbcc"));//true
        System.out.println(new Problem97().isInterleave("aabc", "dbbca", "aadbbcb"));//false
        System.out.println(new Problem97().isInterleave("aabc", "dbbca", "aadbbcbw"));//false
        System.out.println(new Problem97().isInterleave("aabc", "dbbca", "aadbecbw"));//false
    }
}
