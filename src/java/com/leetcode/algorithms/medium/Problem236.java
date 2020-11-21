package com.leetcode.algorithms.medium;

/*
 * 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Tags: Tree, Binary Tree
 * */

public class Problem236 {

  static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    return null;
  }

  public static void main(String[] args) {
    Problem236.TreeNode root = new Problem236.TreeNode(3);
    root.left = new Problem236.TreeNode(5);
    root.right = new Problem236.TreeNode(1);
    root.left.left = new Problem236.TreeNode(6);
    root.left.right = new Problem236.TreeNode(2);
    root.right.left = new Problem236.TreeNode(0);
    root.right.right = new Problem236.TreeNode(8);
    root.left.right.left = new Problem236.TreeNode(7);
    root.left.right.right = new Problem236.TreeNode(4);
    System.out
        .println(new Problem236().lowestCommonAncestor(root, root.left.left, root.left.right));
  }

}
