package com.leetcode.algorithms.medium;

import java.util.*;

/*
 * 133. Clone Graph
 * https://leetcode.com/problems/clone-graph/
 * Tags: Graph, Depth First Search (DFS)
 * */

public class Problem133 {

    // Definition for a Node.
    private static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map<Node, Node> oldToNew = new HashMap<>();

    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    private Node dfs(Node node) {
        if(node == null) {
            return null;
        }
        if(oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        }

        Node copy = new Node(node.val);
        oldToNew.put(node, copy);
        for(Node neighbor: node.neighbors) {
            copy.neighbors.add(dfs(neighbor));
        }
        return copy;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);
        System.out.println(new Problem133().cloneGraph(node1));
    }
}
