package com.leetcode.algorithms.medium;

import java.util.*;

/*
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 * Tags: Intervals
 * */

public class Problem56 {

    public int[][] merge(int[][] intervals) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        int currStart = intervals[0][0];
        int currEnd = intervals[0][1];
        for(int i=1; i<intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(start <= currEnd) {
                currEnd = Math.max(currEnd, end);
            } else {
                List<Integer> newInterval = new ArrayList<>();
                newInterval.add(currStart);
                newInterval.add(currEnd);
                result.add(newInterval);
                currStart = start;
                currEnd = end;
            }
        }
        List<Integer> lastInterval = new ArrayList<>();
        lastInterval.add(currStart);
        lastInterval.add(currEnd);
        result.add(lastInterval);

        int[][] arr = result.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Problem56().merge(new int[][]{new int[]{1,3},new int[]{2,6},new int[]{8,10},new int[]{15,18}})));//[[1,6],[8,10],[15,18]]
        System.out.println(Arrays.deepToString(new Problem56().merge(new int[][]{new int[]{1,4},new int[]{4,5}})));//[[1,5]]
    }
}
