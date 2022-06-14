package com.leetcode.algorithms.medium;

/*
 * 120. Triangle
 * https://leetcode.com/problems/triangle/
 * Tags: Dynamic Programming
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> lastRow = triangle.get(triangle.size()-1);
        int cache[][] = new int[triangle.size()][lastRow.size()];
        for(int i=0; i< lastRow.size(); i++){
            cache[triangle.size()-1][i] = lastRow.get(i);
        }

        for(int i=triangle.size()-2; i>=0; i--) {
            List<Integer> currRow = triangle.get(i);
            for(int j=0; j<currRow.size(); j++) {
                cache[i][j] = Math.min(cache[i+1][j], cache[i+1][j+1]) + currRow.get(j);
            }
        }
        //System.out.println(Arrays.deepToString(cache));
        return cache[0][0];
    }

    public static void main(String[] args) {
        //[[2],[3,4],[6,5,7],[4,1,8,3]]
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(2));
        list.add(List.of(3,4));
        list.add(List.of(6,5,7));
        list.add(List.of(4,1,8,3));
        System.out.println(new Problem120().minimumTotal(list));
    }
}
