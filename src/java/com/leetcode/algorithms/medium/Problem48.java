package com.leetcode.algorithms.medium;

import java.util.Arrays;

/*
 * 48. Rotate Image
 * https://leetcode.com/problems/rotate-image/
 * Tags: Matrix, Array, 2D Array
 * */

public class Problem48 {

  public void rotate(int[][] matrix) {
    int l=0, r=matrix[0].length-1;

    while(l<r) {
      for(int i=1;i<=(r-l);i++) {
        int t = l, b = r;

        int topLeft = matrix[t][l+i];
        matrix[t][l+i] = matrix[b-i][l];
        matrix[b-i][l] = matrix[b][r-i];
        matrix[b][r-i] = matrix[t+i][r];
        matrix[t+i][r] = topLeft;
      }
      l+=1;
      r-=1;
    }
  }

  public void rotate1(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < i; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < Math.floor(matrix.length / 2); j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][matrix.length - 1 - j];
        matrix[i][matrix.length - 1 - j] = temp;
      }
    }
  }

  public static void main(String[] args) {
    Problem48 problem48 = new Problem48();
    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    problem48.rotate(matrix);
    System.out.println(Arrays.deepToString(matrix));
    /*
     * [7, 4, 1]
     * [8, 5, 2]
     * [9, 6, 3]
     * */
  }
}
