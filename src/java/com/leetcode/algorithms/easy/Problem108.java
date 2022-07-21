package com.leetcode.algorithms.easy;

/*
 * 108. Convert Sorted Array to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * Tags: Binary Search Tree
 * */

public class Problem108 {

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

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }

        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, left, mid-1);
        root.right = dfs(nums, mid+1, right);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(new Problem108().sortedArrayToBST(new int[]{-10,-3,0,5,9}));//TreeNode{val=0, left=TreeNode{val=-10, left=null, right=TreeNode{val=-3, left=null, right=null}}, right=TreeNode{val=5, left=null, right=TreeNode{val=9, left=null, right=null}}}
    }
}
