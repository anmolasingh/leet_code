package com.lintcode.algorithms.medium;

import java.util.*;

/*
 * 178 · Graph Valid Tree
 * https://www.lintcode.com/problem/178/
 * Tags: Graph, Depth First Search (DFS)
 * */

public class Problem178 {

    Set<Integer> visited;
    Map<Integer, List<Integer>> ajList;

    public boolean validTree(int n, int[][] edges) {
        visited = new HashSet<>();
        ajList = new HashMap<>();
        for(int i=0; i<n; i++) {
            ajList.put(i, new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++) {
            ajList.get(edges[i][0]).add(edges[i][1]);
            ajList.get(edges[i][1]).add(edges[i][0]);
        }
        if(!dfs(0,-1)) {
            return false;
        }
        return visited.size() == n;
    }

    private boolean dfs(int i, int prev){
        if(visited.contains(i)) {
            return false;
        }
        visited.add(i);
        for(Integer adj : ajList.get(i)) {
            if(adj == prev) {
                continue;
            }
            if(!dfs(adj, i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem178().validTree(5, new int[][]{{0,1},{0,2},{0,3},{1,4}}));//true
        System.out.println(new Problem178().validTree(5, new int[][]{{0,1},{1,2},{2,3},{1,3},{1,4}}));//false
    }
}
