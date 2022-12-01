package com.leetcode.algorithms.hard;

import java.util.*;

/*
 * 140. Word Break II
 * https://leetcode.com/problems/word-break-ii/
 * Tags: Dynamic Programming
 * */

public class Problem140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> cache = new HashMap<>();
        return dfs(wordDict, s, cache);
    }

    private List<String> dfs(List<String> wordDict, String sub, Map<String, List<String>> cache) {
        if(cache.containsKey(sub)) {
            return cache.get(sub);
        }
        if(sub.equals("")) {
            return new ArrayList<String>();
        }

        List<String> result = new ArrayList<>();
        for(int i=0; i<sub.length(); i++) {
            String prefix = sub.substring(0, i+1);
            for(String word : wordDict) {
                if(word.equals(prefix)) {
                    if(prefix.equals(sub)) {
                        result.add(prefix);
                    } else {
                        List<String> restOfWords = dfs(wordDict, sub.substring(i+1), cache);
                        for(String restWord : restOfWords) {
                            result.add(prefix + " " + restWord);
                        }
                    }
                }
            }
        }
        cache.put(sub, result);
        return result;
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        System.out.println(new Problem140().wordBreak("catsanddog", wordDict));//["cats and dog","cat sand dog"]
    }
}
