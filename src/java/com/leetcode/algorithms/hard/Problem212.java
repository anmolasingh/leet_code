package com.leetcode.algorithms.hard;

import java.util.*;

/*
 * 212. Word Search II
 * https://leetcode.com/problems/word-search-ii/
 * Tags: Matrix, Trie, Depth First Search (DFS)
 * */

public class Problem212 {

    private static class Node {
        public Map<Character, Node> children;
        public boolean isEndOfWord;

        public Node() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    private Node root;

    int ROWS, COLS;
    Set<String> visited = new HashSet<>();
    Set<String> result = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        ROWS = board.length;
        COLS = board[0].length;

        root = new Node();
        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }

        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                dfs(board, words, i, j, "", root);
            }
        }
        return new ArrayList<String>(result);
    }

    private void dfs(char[][] board, String[] words, int i, int j, String prefix, Node node) {
        if(i < 0 || i >= ROWS || j < 0 || j >= COLS || visited.contains(i + ":" + j)
                || !node.children.containsKey(board[i][j])) {
            return;
        }

        visited.add(i +":"+j);

        Node child = node.children.get(board[i][j]);
        prefix += board[i][j];
        if(child.isEndOfWord) {
            result.add(prefix);
        }
        dfs(board, words, i+1, j, prefix, child);
        dfs(board, words, i, j+1, prefix, child);
        dfs(board, words, i-1, j, prefix, child);
        dfs(board, words, i, j-1, prefix, child);

        visited.remove(i +":"+j);
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

    public static void main(String[] args) {
        System.out.println(new Problem212().findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}}, new String[]{"oath","pea","eat","rain"}));//[oath, eat]
    }
}
