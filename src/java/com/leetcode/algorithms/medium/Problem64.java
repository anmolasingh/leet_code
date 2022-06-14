package com.leetcode.algorithms.medium;

/*
 * 64. Minimum Path Sum
 * https://leetcode.com/problems/minimum-path-sum/
 * Tags: Dynamic Programming
 * */

import java.util.Arrays;

public class Problem64 {

    public int minPathSum(int[][] grid) {
        int cache[][] = new int[grid.length][grid[0].length];
        /*for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                cache[i][j] = -1;
            }
        }*/

        for (int i=grid.length-1;i>=0;i--){
            for (int j=grid[0].length-1;j>=0;j--){
                int down = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
                boolean hasForwardPath = false;
                if (i+1 < grid.length){
                    down = cache[i+1][j];
                    hasForwardPath = true;
                }
                if (j+1 < grid[0].length){
                    right = cache[i][j+1];
                    hasForwardPath = true;
                }
                cache[i][j] = grid[i][j];
                if (hasForwardPath){
                    cache[i][j] += Math.min(down, right);
                }
            }
        }
        //System.out.println(Arrays.deepToString(cache));
        return cache[0][0];
    }

    public static void main(String[] args) throws Exception {
        Problem64 problem64 = new Problem64();
        int [][]grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        if(problem64.minPathSum(grid) != 7) throw new Exception("Incorrect");
        grid = new int[][]{{1, 2, 3}, {4, 5, 6}};
        if(problem64.minPathSum(grid) != 12) throw new Exception("Incorrect");
        grid = new int[][]{{1,3,1}};
        if(problem64.minPathSum(grid) != 5) throw new Exception("Incorrect");
        grid = new int[][]{{4}};
        if(problem64.minPathSum(grid) != 4) throw new Exception("Incorrect");
        grid = new int[][]{{0}};
        if(problem64.minPathSum(grid) != 0) throw new Exception("Incorrect");
        grid = new int[][]{{0,0}};
        if(problem64.minPathSum(grid) != 0) throw new Exception("Incorrect");
    }
}
