package com.leetcode.algorithms.medium;

/*
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 * Tags: Depth First Search (DFS), Union Find
 * */

import com.ds.unionfind.UnionFind;

import java.util.*;

public class Problem200 {

  Set<String> visited = new HashSet<>();
  int ROWS, COLS;
  //DFS
  public int numIslands(char[][] grid) {
    int result = 0;
    ROWS = grid.length;
    COLS = grid[0].length;

    for(int i=0; i<ROWS; i++) {
      for(int j=0; j< COLS; j++) {
        if(grid[i][j] == '1' && !visited.contains(i + ":" + j)) {
          dfs(grid, i, j);
          result++;
        }
      }
    }
    return result;
  }

  private void dfs(char[][] grid, int r, int c) {
    if(visited.contains(r + ":" + c)) {
      return;
    }
    if(r < 0 || c < 0 || r == ROWS || c == COLS || grid[r][c] != '1') {
      return;
    }
    visited.add(r + ":" + c);
    dfs(grid, r+1, c);
    dfs(grid, r, c+1);
    dfs(grid, r-1, c);
    dfs(grid, r, c-1);
  }

  //Union Find
  public int numIslands1(char[][] grid) {
    int colLength = grid[0].length;
    UnionFind unionFind = new UnionFind(grid.length * colLength);

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          unionFind.union(twoDToOneD(i, j, colLength),
              twoDToOneD(i, j, colLength));//Union with self to set inUse
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
    System.out.println(problem200.numIslands(grid));//3
  }
}
