package com.leetcode.algorithms.medium;

/*
 * 63. Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/
 * Tags: Dynamic Programming
 * */

import java.util.Arrays;

public class Problem63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1){
            return 0;
        }

        int cache[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            if(obstacleGrid[i][0] == 1) {
                break;
            }
            cache[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if(obstacleGrid[0][i] == 1) {
                break;
            }
            cache[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i - 1][j] != 1) {
                    cache[i][j] += cache[i - 1][j];
                }
                if(obstacleGrid[i][j-1] != 1) {
                    cache[i][j] += cache[i][j - 1];
                }
            }
        }
        System.out.println(Arrays.deepToString(cache));
        return cache[m-1][n-1];
    }

    public static void main(String[] args) {
        Problem63 problem62 = new Problem63();
        //int obstacleGrid[][] = {{0,0,0},{0,1,0},{0,0,0}};
        //int obstacleGrid[][] = {{0,0},{0,1}};
        int obstacleGrid[][] = {{1,0}};
        System.out.println(problem62.uniquePathsWithObstacles(obstacleGrid));
    }
}
