package com.leetcode.algorithms.medium;

import java.util.Stack;

/*
 * 114. Flatten Binary Tree to Linked List
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/submissions/
 * Tags: Tree, Linked List
 * */

public class Problem114 {

  public static class TreeNode {

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
  }

  public void flatten(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    TreeNode lastCurr = null;
    while (!stack.isEmpty()) {
      TreeNode curr = stack.pop();
      while (curr != null) {
        //System.out.print(curr.val + " ");
        if (lastCurr != null) {
          lastCurr.right = curr;
          lastCurr.left = null;
        }
        if (curr.right != null) {
          stack.push(curr.right);
        }

        if (curr.left != null) {
          curr.right = curr.left;
        }

        lastCurr = curr;
        curr = curr.left;
      }
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.right = new TreeNode(6);
    Problem114 problem114 = new Problem114();
    problem114.flatten(root);

    System.out.println();
    while (root != null) {
      System.out.print(root.val + " ");
      root = root.right;
    }
  }

}
