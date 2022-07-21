package com.leetcode.algorithms.medium;

/*
 * 1448. Count Good Nodes in Binary Tree
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 * Tags: Binary Tree
 * */

public class Problem1448 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxParent) {
        if(node == null) {
            return 0;
        }

        int total = 0;
        if(node.val >= maxParent) {
            total += 1;
        }
        total += dfs(node.left, Math.max(node.val, maxParent));
        total += dfs(node.right, Math.max(node.val, maxParent));
        return total;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(new Problem1448().goodNodes(root));//4
    }
}
