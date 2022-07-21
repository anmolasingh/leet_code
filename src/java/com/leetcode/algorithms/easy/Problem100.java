package com.leetcode.algorithms.easy;

/*
 * 100. Same Tree
 * https://leetcode.com/problems/same-tree/
 * Tags: Binary Tree
 * */

public class Problem100 {

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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        } else if(p == null) {
            return false;
        } else if(q == null) {
            return false;
        }

        if(p.val != q.val) {
            return false;
        }

        return dfs(p.left, q.left) && dfs(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        System.out.println(new Problem100().isSameTree(p, q));//true
    }
}
