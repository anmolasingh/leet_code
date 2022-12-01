package com.leetcode.algorithms.medium;

import java.util.*;

/*
 * 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * Tags: Trees, Trie
 * */

public class Problem208 {

    private static class Node {
        public Map<Character, Node> children;
        public boolean isEndOfWord;

        public Node() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    private Node root;

    public Problem208() {
        root = new Node();
    }

    public void insert(String word) {
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
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(!curr.children.containsKey(ch)) {
                return false;
            }
            curr = curr.children.get(ch);
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for(int i=0; i<prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(!curr.children.containsKey(ch)) {
                return false;
            }
            curr = curr.children.get(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        Problem208 problem208 =  new Problem208();
        problem208.insert("apple");
        System.out.println(problem208.search("apple"));//true
        System.out.println(problem208.search("app"));//false
        System.out.println(problem208.startsWith("app"));//true
        problem208.insert("app");
        System.out.println(problem208.search("app"));//true
    }
}
