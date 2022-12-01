package com.leetcode.algorithms.medium;

/*
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/
 * Tags: Dynamic Programming
 * */

import java.util.Arrays;

public class Problem62 {

    public int uniquePaths(int m, int n) {
        int cache[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            cache[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            cache[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cache[i][j] = cache[i-1][j] + cache[i][j-1];
            }
        }
        return cache[m-1][n-1];
    }

    public int uniquePathsDFS(int m, int n) {
        int cache[][] = new int[m][n];
        for(int i=0; i<m; i++) {
            Arrays.fill(cache[i], -1);
        }
        return dfs(m, n, 0, 0, cache);
    }

    private int dfs(int m, int n, int i, int j, int[][] cache) {
        if(i == m || j == n) {
            return 0;
        } else if(i == m-1 && j == n-1) {
            return 1;
        } else if(cache[i][j] != -1) {
            return cache[i][j];
        }

        cache[i][j] = dfs(m, n, i+1, j, cache) + dfs(m, n, i, j+1, cache);
        return cache[i][j];
    }

    public static void main(String[] args) {
        Problem62 problem62 = new Problem62();
        System.out.println(problem62.uniquePaths(3, 7));
    }
}
