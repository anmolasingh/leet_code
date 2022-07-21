package com.leetcode.algorithms.easy;

/*
 * 226. Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/
 * Tags: Binary Tree
 * */

import com.leetcode.algorithms.medium.Problem1448;

public class Problem226 {

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

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if(node == null) {
            return;
        }

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        dfs(node.left);
        dfs(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(new Problem226().invertTree(root));
    }
}
