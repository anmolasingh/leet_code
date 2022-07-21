package com.leetcode.algorithms.medium;

import com.leetcode.algorithms.easy.Problem235;

import java.util.*;

/*
 * 102. Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * Tags: Binary Tree, Queue
 * */

public class Problem102 {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.add(root);
        Queue<TreeNode> queue2 = new LinkedList<>();
        while(!queue1.isEmpty() || !queue2.isEmpty()) {
            List<Integer> currList = new ArrayList<>();
            while(!queue1.isEmpty()) {
                TreeNode currNode = queue1.remove();
                currList.add(currNode.val);
                if(currNode.left != null) {
                    queue2.add(currNode.left);
                }
                if(currNode.right != null) {
                    queue2.add(currNode.right);
                }

            }

            if(currList.size() > 0) {
                result.add(new ArrayList<Integer>(currList));
                currList = new ArrayList<>();
            }

            while(!queue2.isEmpty()) {
                TreeNode currNode = queue2.remove();
                currList.add(currNode.val);
                if(currNode.left != null) {
                    queue1.add(currNode.left);
                }
                if(currNode.right != null) {
                    queue1.add(currNode.right);
                }
            }
            if(currList.size() > 0) {
                result.add(new ArrayList<Integer>(currList));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        System.out.println(new Problem102().levelOrder(root));//[[6], [2, 8]]
    }
}
