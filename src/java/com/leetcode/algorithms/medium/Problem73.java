package com.leetcode.algorithms.medium;

import java.util.Arrays;

/*
 * 73. Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/
 * Tags: Array, 2D Array, Matrix
 * */

public class Problem73 {

    public void setZeroes(int[][] matrix) {
        int rowIndicator[] = new int[matrix.length];
        int colIndicator[] = new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0) {
                    //Marking
                    rowIndicator[i] = 2;
                    colIndicator[j] = 2;
                }
            }
        }

        for(int i=0;i<rowIndicator.length;i++){
            if(rowIndicator[i] == 2) {
                for(int j=0; j<matrix[0].length;j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i=0;i<colIndicator.length;i++){
            if(colIndicator[i] == 2) {
                for(int j=0; j<matrix.length;j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new Problem73().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));//[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
    }
}
