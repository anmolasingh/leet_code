package com.leetcode.algorithms.medium;

import java.util.*;

/*
 * 994. Rotting Oranges
 * https://leetcode.com/problems/rotting-oranges/
 * Tags: Matrix
 * Companies: Microsoft
 * */

public class Problem994 {

    private static class Node {
        int row;
        int col;
        public Node(int r, int c) {
            row = r;
            col = c;
        }
    }

    public int orangesRotting(int[][] grid) {
        int fresh = 0, minutes = 0, ROWS = grid.length, COLUMNS = grid[0].length;
        Queue<Node> q = new LinkedList<>();
        for(int m = 0; m < ROWS; m++) {
            for(int n = 0; n < COLUMNS; n++) {
                if(grid[m][n] == 1) {
                    fresh += 1;
                } else if (grid[m][n] == 2) {
                    q.add(new Node(m,n));
                }
            }
        }

        List<Node> directions = new ArrayList<>();
        directions.add(new Node(0, 1));
        directions.add(new Node(0, -1));
        directions.add(new Node(1, 0));
        directions.add(new Node(-1, 0));

        while(!q.isEmpty() && fresh > 0) {
            int sizeSnapshot = q.size();
            for(int i=0; i<sizeSnapshot;i++) {
                Node n = q.remove();
                for(Node d : directions) {
                    int r = n.row + d.row;
                    int c = n.col + d.col;
                    if(r >= 0 && r < ROWS && c >= 0 && c< COLUMNS && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        q.add(new Node(r,c));
                        fresh -= 1;
                    }
                }
            }
            minutes += 1;
        }
        return fresh == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        System.out.println(new Problem994().orangesRotting(new int[][]{new int[]{2,1,1},new int[]{1,1,0},new int[]{0,1,1}}));//4
    }
}
