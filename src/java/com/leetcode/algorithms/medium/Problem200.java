package com.leetcode.algorithms.medium;

/*
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 * Tags: Union Find
 * */

import com.ds.unionfind.UnionFind;

public class Problem200 {

    public int numIslands(char[][] grid) {
        int colLength = grid[0].length;
        UnionFind unionFind = new UnionFind(grid.length * colLength);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    unionFind.union(twoDToOneD(i, j, colLength), twoDToOneD(i, j, colLength));//Union with self to set inUse
                    if ((i - 1) >= 0 && grid[i - 1][j] == '1') {
                        unionFind.union(twoDToOneD(i, j, colLength), twoDToOneD(i - 1, j, colLength));
                    }
                    if ((j - 1) >= 0 && grid[i][j - 1] == '1') {
                        unionFind.union(twoDToOneD(i, j, colLength), twoDToOneD(i, j - 1, colLength));
                    }
                }
            }
        }

        return unionFind.count();
    }

    private int twoDToOneD(int i, int j, int colLength) {
        return i * colLength + j;
    }

    public static void main(String[] args) {
        Problem200 problem200 = new Problem200();
        char grid[][] = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(problem200.numIslands(grid));
    }
}
