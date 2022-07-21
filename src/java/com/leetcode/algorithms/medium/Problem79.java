package com.leetcode.algorithms.medium;

import java.util.*;

/*
 * 79. Word Search
 * https://leetcode.com/problems/word-search/
 * Tags: Matrix, Array, 2D Array
 * */

public class Problem79 {

    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                Set<String> path = new HashSet<>();
                if (dfs(i, j, 0, board, word, path)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, int mi, char[][] board, String word, Set<String> path) {
        if(mi == word.length()) {
            return true;
        }

        if( r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return false;
        }
        if(board[r][c] != word.charAt(mi) || path.contains("r=" + r + ":c=" + c)) {
            return false;
        }

        path.add("r=" + r + ":c=" + c);
        boolean res = dfs(r+1, c, mi + 1, board, word, path)
                || dfs(r, c+1, mi + 1, board, word, path)
                || dfs(r-1, c, mi + 1, board, word, path)
                || dfs(r, c-1, mi + 1, board, word, path);
        path.remove("r=" + r + ":c=" + c);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Problem79().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));//true
    }
}
