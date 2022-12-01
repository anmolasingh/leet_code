package com.leetcode.algorithms.medium;

/*
 * 743. Network Delay Time
 * https://leetcode.com/problems/network-delay-time/
 * Tags: Graph
 * */

import java.util.*;

public class Problem743 {

    private static class Node implements Comparable<Node> {
        int destination;
        int distance;

        public Node(int destination, int distance) {
            this.destination = destination;
            this.distance = distance;
        }

        public int compareTo(Node n){
            return this.distance - n.distance;
        }
    }

    //Djikstra
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Node>> adj = new HashMap<>();
        for(int i=1; i<=n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int i=0; i<times.length; i++) {
            List<Node> l = adj.get(times[i][0]);
            l.add(new Node(times[i][1], times[i][2]));
        }

        Set<Integer> visit = new HashSet<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(k,0));
        int cost = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(visit.contains(node.destination)) {
                continue;
            }
            visit.add(node.destination);
            cost = Math.max(cost, node.distance);
            for(Node nei : adj.get(node.destination)) {
                pq.add(new Node(nei.destination, node.distance + nei.distance));
            }
        }
        if(visit.size() == n) {
            return cost;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem743().networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2));//2
    }
}
