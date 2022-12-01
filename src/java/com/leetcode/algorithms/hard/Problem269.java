package com.leetcode.algorithms.hard;

import java.util.*;

/*
 * 269. Alien Dictionary
 * https://leetcode.com/problems/alien-dictionary/
 * Tags: Graphs, Topological Sort
 * */

public class Problem269 {

    Map<Character, List<Character>> adj;

    //false - visited, true - current path
    Map<Character, Boolean> visited;

    List<Character> result;

    public String alienOrder(String[] words) {
        adj = new HashMap<>();
        for(int i=0; i< words.length; i++) {
            String w = words[i];
            for(int j=0; j<w.length(); j++) {
                adj.put(w.charAt(j), new ArrayList<Character>());
            }
        }

        for(int i=0; i<words.length-1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            int minLen = Math.min(w1.length(), w2.length());
            if(w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                //Failure case for ["dbca", "dbc] as it does not fulfill criteria of sorted array
                return "";
            }
            for(int j=0; j<minLen; j++) {
                if(w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }
        System.out.println(adj);

        visited = new HashMap<>();
        result = new ArrayList<>();
        for (Character c : adj.keySet()) {
            if(dfs(c)) {
                return "";
            }
        }

        Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        result.forEach(c -> sb.append(c));
        return sb.toString();
    }

    private boolean dfs(Character c) {
        if(visited.containsKey(c)) {
            return visited.get(c);
        }

        visited.put(c, true);
        for(Character neighbour : adj.get(c)) {
            if(dfs(neighbour)) {
                return true;
            }
        }
        visited.put(c, false);
        result.add(c);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Problem269().alienOrder(new String[]{"wrt","wrf","er","ett","rftt"}));//wertf
    }
}
