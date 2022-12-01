package com.leetcode.algorithms.medium;

/*
 * 787. Cheapest Flights Within K Stops
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 * Tags: Graph
 * */

import java.util.*;

public class Problem787 {
    private static class Node implements Comparable<Node> {
        int destination;
        int distance;
        int hops;

        public Node(int destination, int distance, int hops) {
            this.destination = destination;
            this.distance = distance;
            this.hops = hops;
        }

        public int compareTo(Node n){
            return this.distance - n.distance;
        }
    }

    //Bellman Ford
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        for(int i=0; i<n; i++) {
            prices[i] = Integer.MAX_VALUE;
        }
        prices[src] = 0;

        for(int iter = 0; iter <= k; iter++) {
            int[] tempPrices = new int[n];
            for(int j=0; j<n; j++) {
                tempPrices[j] = prices[j];
            }
            for(int i=0; i<flights.length; i++) {
                int source = flights[i][0];
                int destination = flights[i][1];
                int price = flights[i][2];
                if(prices[source] == Integer.MAX_VALUE) {
                    continue;
                }
                if(prices[source] + price < tempPrices[destination]) {
                    tempPrices[destination] = prices[source] + price;
                }
            }
            prices = tempPrices;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }

    //Djikstra - Time Limit Exceeded
    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Node>> adj = new HashMap<>();
        for(int i=0; i<n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int i=0; i<flights.length; i++) {
            List<Node> l = adj.get(flights[i][0]);
            l.add(new Node(flights[i][1], flights[i][2], 0));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(src,0, 0));
        int cost = Integer.MAX_VALUE;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(node.hops > k+1) {
                continue;
            }
            if(node.destination == dst && node.hops <= k+1) {
                cost = Math.min(cost, node.distance);
            }

            for(Node nei : adj.get(node.destination)) {
                pq.add(new Node(nei.destination, node.distance + nei.distance, node.hops + 1));
            }
        }
        return cost == Integer.MAX_VALUE ? -1 : cost;
    }

    public static void main(String[] args) {
        System.out.println(new Problem787().findCheapestPrice(4,new int[][]{{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}},0,3,1));//700
    }
}
