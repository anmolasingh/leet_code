package com.leetcode.algorithms.medium;

import java.util.*;

/*
 * 1584. Min Cost to Connect All Points
 * https://leetcode.com/problems/min-cost-to-connect-all-points/
 * Tags: Graph, Minimum Spanning Tree
 * */

public class Problem1584 {

    private class Node implements Comparable<Node> {
        int distance;
        int point;

        public Node(int distance, int point) {
            this.distance = distance;
            this.point = point;
        }

        public int compareTo(Node n){
            return this.distance - n.distance;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<Node>> adjList = new HashMap<>();
        int N = points.length;
        for(int i=0; i<N; i++) {
            adjList.put(i, new ArrayList<Node>());
        }
        for(int i=0; i<N; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j=i+1; j<N; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int distance = Math.abs(x1-x2) + Math.abs(y1-y2);
                adjList.get(i).add(new Node(distance, j));
                adjList.get(j).add(new Node(distance, i));
            }
        }

        //Prim's Algorithm
        int result = 0;
        Set<Integer> visit = new HashSet<>();
        PriorityQueue<Node> minPQ = new PriorityQueue<>();
        minPQ.add(new Node(0,0));
        while(visit.size() < N) {
            Node min = minPQ.poll();
            if(visit.contains(min.point)) {
                continue;
            }
            result += min.distance;
            visit.add(min.point);
            for(Node neighbour : adjList.get(min.point)) {
                minPQ.add(new Node(neighbour.distance, neighbour.point));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1584().minCostConnectPoints(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}}));//20
        System.out.println(new Problem1584().minCostConnectPoints(new int[][]{{3,12},{-2,5},{-4,1}}));//18
    }
}
