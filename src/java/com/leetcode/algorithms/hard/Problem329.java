package com.leetcode.algorithms.hard;

/*
 * 329. Longest Increasing Path in a Matrix
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 * Tags: Matrix, Dynamic Programming
 * */

public class Problem329 {

    int[][] cache;
    int[][] directions;

    public int longestIncreasingPath(int[][] matrix) {
        int result = 1;
        directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        cache = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                result = Math.max(result, dfs(matrix, i, j));
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if(cache[i][j] != 0) {
            return cache[i][j];
        }

        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        int result = 0;
        for(int k=0; k<directions.length; k++) {
            int r = i + directions[k][0];
            int c = j + directions[k][1];
            if(r >= 0 && r < ROWS && c >= 0 && c< COLS && matrix[r][c] > matrix[i][j]) {
                result = Math.max(result, dfs(matrix, r, c));
            }
        }
        cache[i][j] = result + 1;
        return cache[i][j];
    }

    public static void main(String[] args) {
        System.out.println(new Problem329().longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));//4
    }
}
