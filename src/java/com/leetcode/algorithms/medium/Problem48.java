package com.leetcode.algorithms.medium;

import java.util.Arrays;

/*
 * 48. Rotate Image
 * https://leetcode.com/problems/rotate-image/
 * Tags: Matrix, Array, 2D Array
 * */

public class Problem48 {

  public void rotate(int[][] matrix) {
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
    print(matrix);
    problem48.rotate(matrix);
    print(matrix);
  }

  private static void print(int[][] matrix) {
    System.out.println("-----------------------");
    for (int i = 0; i < matrix.length; i++) {
      System.out.println(Arrays.toString(matrix[i]));
    }
  }

}
