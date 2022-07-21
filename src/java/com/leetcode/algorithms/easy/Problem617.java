package com.leetcode.algorithms.easy;

/*
 * 617. Merge Two Binary Trees
 * https://leetcode.com/problems/merge-two-binary-trees/
 * Tags: Binary Tree
 * */

public class Problem617 {

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

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }

    private TreeNode dfs(TreeNode node1, TreeNode node2) {
        TreeNode resultNode;
        if(node1 == null && node2 == null) {
            return null;
        } else if(node1 == null) {
            resultNode = new TreeNode(node2.val);
            resultNode.left = dfs(null, node2.left);
            resultNode.right = dfs(null, node2.right);
        } else if(node2 == null) {
            resultNode = new TreeNode(node1.val);
            resultNode.left = dfs(node1.left, null);
            resultNode.right = dfs(node1.right, null);
        } else {
            resultNode = new TreeNode(node1.val + node2.val);
            resultNode.left = dfs(node1.left, node2.left);
            resultNode.right = dfs(node1.right, node2.right);
        }
        return resultNode;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(4);
        root2.right = new TreeNode(5);

        System.out.println(new Problem617().mergeTrees(root1, root2));//TreeNode{val=5, left=TreeNode{val=3, left=null, right=null}, right=TreeNode{val=7, left=null, right=null}}
    }
}
