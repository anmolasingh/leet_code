package com.leetcode.algorithms.medium;

import java.util.*;

/*
 * 211. Design Add and Search Words Data Structure
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 * Tags: Trees, Trie
 * */

public class Problem211 {

    private static class Node {
        public Map<Character, Node> children;
        public boolean isEndOfWord;

        public Node() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    private Node root;

    public Problem211() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(!curr.children.containsKey(ch)) {
                curr.children.put(ch, new Node());
            }
            curr = curr.children.get(ch);
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, Node node) {
        if(node == null) {
            return false;
        }
        if(index == word.length()) {
            return node.isEndOfWord;
        }

        char ch = word.charAt(index);
        if(ch != '.') {
            if(node.children.containsKey(ch)) {
                return dfs(word, index+1, node.children.get(ch));
            } else {
                return false;
            }
        } else {
            boolean result = false;
            for(Character key : node.children.keySet()) {
                result = result || dfs(word, index+1, node.children.get(key));
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Problem211 problem211 = new Problem211();
        problem211.addWord("bad");
        problem211.addWord("dad");
        problem211.addWord("mad");
        System.out.println(problem211.search("pad"));//false
        System.out.println(problem211.search("bad"));//true
        System.out.println(problem211.search(".ad"));//true
        System.out.println(problem211.search("b.."));//true
        System.out.println(problem211.search("b..."));//false
    }
}
