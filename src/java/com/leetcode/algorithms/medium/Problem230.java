package com.leetcode.algorithms.medium;

/*
 * 230. Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * Tags: Trees
 * */

import java.util.ArrayList;
import java.util.List;

public class Problem230 {

  static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public int kthSmallest(TreeNode root, int k) {
    List<Integer> sortedList = new ArrayList<>();
    inorder(root, sortedList);
    return sortedList.get(k - 1);
  }

  private void inorder(TreeNode node, List<Integer> sortedList) {

    if (node.left != null) {
      inorder(node.left, sortedList);
    }
    sortedList.add(node.val);
    if (node.right != null) {
      inorder(node.right, sortedList);
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.left.left.left = new TreeNode(1);
    Problem230 problem230 = new Problem230();
    System.out.println(problem230.kthSmallest(root, 2));
  }

}
