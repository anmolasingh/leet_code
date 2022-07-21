package com.leetcode.algorithms.medium;

import java.util.*;

/*
 * 54. Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/
 * Tags: Array, 2D Array, Matrix
 * */

public class Problem54 {

    //Boundaries
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int l=0, r=matrix[0].length, t=0, b=matrix.length;


        while(l<r && t<b) {
            for(int i=l;i<r;i++) {
                result.add(matrix[t][i]);
            }
            t+=1;

            for(int i=t;i<b;i++) {
                result.add(matrix[i][r-1]);
            }
            r-=1;

            if(!(l<r && t<b)) {
                break;
            }

            for(int i=r-1;i>=l;i--) {
                result.add(matrix[b-1][i]);
            }
            b-=1;

            for(int i=b-1;i>=t;i--) {
                result.add(matrix[i][l]);
            }
            l+=1;
        }
        return result;
    }

    //Hash Set
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        Set<String> cellsVisited = new HashSet<>();
        int i=0, j=-1;
        while(cellsVisited.size() < (matrix.length * matrix[0].length)) {
            j+=1;
            while(j < matrix[0].length && !cellsVisited.contains(i + ":" + j)) {
                result.add(matrix[i][j]);
                cellsVisited.add(i + ":" + j);
                j++;
            }
            j-=1;

            i+=1;
            while(i < matrix.length && !cellsVisited.contains(i + ":" + j)) {
                result.add(matrix[i][j]);
                cellsVisited.add(i + ":" + j);
                i++;
            }
            i-=1;

            j-=1;
            while(j >= 0 && !cellsVisited.contains(i + ":" + j)) {
                result.add(matrix[i][j]);
                cellsVisited.add(i + ":" + j);
                j--;
            }
            j+=1;

            i-=1;
            while(i >=0 && !cellsVisited.contains(i + ":" + j)) {
                result.add(matrix[i][j]);
                cellsVisited.add(i + ":" + j);
                i--;
            }
            i+=1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem54().spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));//[1,2,3,4,8,12,11,10,9,5,6,7]
    }
}
