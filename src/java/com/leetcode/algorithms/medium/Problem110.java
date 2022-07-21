package com.leetcode.algorithms.medium;

/*
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/
 * Tags: Binary Tree
 * */

public class Problem110 {

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

    static boolean isBalanced;

    public boolean isBalanced(TreeNode node) {
        isBalanced = true;
        getHeight(node);
        return isBalanced;
    }

    private int getHeight(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left) + 1;
        int rightHeight = getHeight(node.right) + 1;

        if(Math.abs(leftHeight - rightHeight) > 1) {
            isBalanced = false;
        }

        return Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Problem110().isBalanced(root));//true
    }
}
