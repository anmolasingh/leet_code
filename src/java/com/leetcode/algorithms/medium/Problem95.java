package com.leetcode.algorithms.medium;

/*
 * 95. Unique Binary Search Trees II
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 * Tags: Dynamic Programming, Tree, Binary Search Tree, Backtracking
 * */


import java.util.ArrayList;
import java.util.List;

public class Problem95 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

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

    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<TreeNode>();
        }
        return helper(1, n);
    }

    public List<TreeNode> helper(int m, int n){
        List<TreeNode> result = new ArrayList<>();
        if(m > n){
            result.add(null);
            return result;
        }

        for(int i=m; i<=n; i++){
            List<TreeNode> ls = helper(m, i-1);
            List<TreeNode> rs = helper(i+1, n);
            for(TreeNode l: ls){
                for(TreeNode r: rs){
                    TreeNode curr = new TreeNode(i);
                    curr.left=l;
                    curr.right=r;
                    result.add(curr);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem95 problem95 = new Problem95();
        System.out.println(problem95.generateTrees(3));
    }
}
