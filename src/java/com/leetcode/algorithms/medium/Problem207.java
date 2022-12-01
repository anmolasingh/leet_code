package com.leetcode.algorithms.medium;

import java.util.*;

/*
 * 207. Course Schedule
 * https://leetcode.com/problems/course-schedule/
 * Tags: Graph, Depth First Search (DFS)
 * */

public class Problem207 {

    Set<Integer> visit = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();
    Map<Integer, List<Integer>> ajList = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0; i<numCourses; i++) {
            ajList.put(i, new ArrayList<Integer>());
        }
        for(int i=0; i<prerequisites.length; i++) {
            ajList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for(int i=0; i<numCourses; i++) {
            if(!dfs(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course) {
        if(cycle.contains(course)) {
            return false;
        }
        if(visit.contains(course)) {
            return true;
        }
        cycle.add(course);
        List<Integer> preCourses = ajList.get(course);
        for(Integer preCourse : preCourses) {
            if(!dfs(preCourse)) {
                return false;
            }
        }
        cycle.remove(course);
        visit.add(course);
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem207().canFinish(2, new int[][]{{1,0}}));//true
        System.out.println(new Problem207().canFinish(2, new int[][]{{1,0},{0,1}}));//false
    }
}
