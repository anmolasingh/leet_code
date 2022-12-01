package com.leetcode.algorithms.medium;

/*
 * 139. Word Break
 * https://leetcode.com/problems/word-break/
 * Tags: Dynamic Programming
 * */

import java.util.Arrays;
import java.util.List;

public class Problem139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean cache[] = new boolean[s.length()+1];
        cache[s.length()] = true;
        for(int i=s.length()-1;i>=0;i--) {
            for(String word: wordDict) {
                if(i + word.length() <= s.length() && word.equals(s.substring(i, i + word.length()))) {
                    cache[i] = cache[i+ word.length()];
                }
                if(cache[i] == true) {
                    break;
                }
            }
        }
        return cache[0];
    }

    public boolean wordBreakDFS(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0, 0, new int[s.length()]);
    }

    private boolean dfs(String s, List<String> wordDict, int front, int last, int[] cache) {
        if(last >= s.length()) {
            if(front == last) {
                return true;
            } else {
                return false;
            }
        }

        if(cache[front] != 0){
            return cache[front] == 1 ? true : false;
        }

        String currStr = s.substring(front, last+1);
        boolean isPossible = false;
        for (String word: wordDict) {
            if(word.equals(currStr)) {
                isPossible = isPossible || dfs(s, wordDict, last+1, last+1, cache);
            }
        }
        isPossible = isPossible || dfs(s, wordDict, front, last+1, cache);
        cache[front] = isPossible ? 1 : 2;
        return isPossible;
    }

    public static void main(String[] args) {
        System.out.println(new Problem139().wordBreak("leetcode", Arrays.asList("leet","code")));//true
    }
}
