package com.leetcode.algorithms.easy;

/*
 * 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Tags: Binary Tree
 * */

public class Problem104 {

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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(dfs(node.left), dfs(node.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.right = new TreeNode(7);
        System.out.println(new Problem104().maxDepth(root));//3
    }
}
