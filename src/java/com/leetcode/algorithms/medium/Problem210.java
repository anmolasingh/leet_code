package com.leetcode.algorithms.medium;

import java.util.*;

/*
 * 210. Course Schedule II
 * https://leetcode.com/problems/course-schedule-ii/
 * Tags: Graph, Depth First Search (DFS), Topological Sort
 * */

public class Problem210 {

    Set<Integer> visit = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();
    Map<Integer, List<Integer>> ajList = new HashMap<>();
    List<Integer> output = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int i=0; i<numCourses; i++) {
            ajList.put(i, new ArrayList<Integer>());
        }
        for(int i=0; i<prerequisites.length; i++) {
            ajList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for(int i=0; i<numCourses; i++) {
            if(!dfs(i)) {
                return new int[0];
            }
        }

        int result[] = new int[output.size()];
        int in = 0;
        for(Integer c : output) {
            result[in] = c;
            in++;
        }
        return result;
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
        output.add(course);
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Problem210().findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}})));//[0,1,2,3] OR [0,2,1,3]
    }
}
