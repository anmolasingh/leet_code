package com.leetcode.algorithms.medium;

import java.util.*;

/*
 * 435. Non-overlapping Intervals
 * https://leetcode.com/problems/non-overlapping-intervals/
 * Tags: Intervals
 * */

public class Problem435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        int result = 0;
        int currEnd = intervals[0][1];
        for(int i=1; i<intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(start < currEnd) {
                result++;
                currEnd = Math.min(currEnd, end);
            } else {
                currEnd = end;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem435().eraseOverlapIntervals(new int[][]{new int[]{1,2},new int[]{2,3},new int[]{3,4},new int[]{1,3}}));//1
        System.out.println(new Problem435().eraseOverlapIntervals(new int[][]{new int[]{1,100},new int[]{11,22},new int[]{1,11},new int[]{2,12}}));//2
    }
}
