package com.leetcode.algorithms.medium;

import java.util.*;

/*
 * 417. Pacific Atlantic Water Flow
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 * Tags: Graph, Matrix, Depth First Search (DFS)
 * */

public class Problem417 {

    int ROWS, COLS;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        ROWS = heights.length;
        COLS = heights[0].length;
        Set<String> flowsToPacific = new HashSet<>();
        Set<String> flowsToAtlantic = new HashSet<>();
        for(int i=0; i< ROWS; i++) {
            dfs(i, 0, heights, heights[i][0], flowsToPacific);
            dfs(i, COLS-1, heights, heights[i][COLS-1], flowsToAtlantic);
        }
        for(int i=0; i< COLS; i++) {
            dfs(0, i, heights, heights[0][i], flowsToPacific);
            dfs(ROWS-1, i, heights, heights[ROWS-1][i], flowsToAtlantic);
        }

        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                String key = i + ":" + j;
                if(flowsToPacific.contains(key) && flowsToAtlantic.contains(key)) {
                    List<Integer> r = new ArrayList<>();
                    r.add(i);
                    r.add(j);
                    result.add(r);
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, int[][] heights, int prevHeight, Set<String> visited) {
        if(visited.contains(r + ":" + c) || r < 0 || c < 0 || r == ROWS || c == COLS) {
            return;
        }
        if(heights[r][c] < prevHeight) {
            return;
        }
        visited.add(r + ":" + c);
        dfs(r+1, c, heights, heights[r][c], visited);
        dfs(r, c+1, heights, heights[r][c], visited);
        dfs(r-1, c, heights, heights[r][c], visited);
        dfs(r, c-1, heights, heights[r][c], visited);
    }

    public static void main(String[] args) {
        System.out.println(new Problem417().pacificAtlantic(new int[][]{{1,2,3},{8,9,4},{7,6,5}}));//[[0,2],[1,0],[1,2],[2,0],[2,1],[2,2]]
    }
}
