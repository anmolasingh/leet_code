package com.leetcode.algorithms.medium;

import java.util.*;

/*
 * 57. Insert Interval
 * https://leetcode.com/problems/insert-interval/
 * Tags: Intervals
 * */

public class Problem57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<intervals.length; i++) {
            if(newInterval[1] < intervals[i][0]) {
                result.add(new ArrayList<Integer>(Arrays.asList(newInterval[0], newInterval[1])));
                for(int j=i; j<intervals.length; j++) {
                    result.add(new ArrayList<Integer>(Arrays.asList(intervals[j][0], intervals[j][1])));
                }
                int[][] arr = result.stream()
                        .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                        .toArray(int[][]::new);
                return arr;
            } else if(newInterval[0] > intervals[i][1]) {
                result.add(new ArrayList<Integer>(Arrays.asList(intervals[i][0], intervals[i][1])));
            } else {
                //Merge
                int start = Math.min(intervals[i][0], newInterval[0]);
                int end = Math.max(intervals[i][1], newInterval[1]);
                newInterval = new int[]{start, end};
            }
        }
        result.add(Arrays.asList(newInterval[0], newInterval[1]));

        int[][] arr = result.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Problem57().insert(new int[][]{{1,3},{6,9}}, new int[]{2,5})));//[[1,5],[6,9]]
    }
}
