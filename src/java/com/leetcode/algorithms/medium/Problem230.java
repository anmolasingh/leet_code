package com.leetcode.algorithms.medium;

/*
 * 230. Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * Tags: Trees
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    /*2 approaches*/
    /*inorder(root, sortedList);
    return sortedList.get(k - 1);*/
    /*OR*/
    return iterativeInorder(root, k); //Better performance
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

  private int iterativeInorder(TreeNode root, int k){
    Stack<TreeNode> s = new Stack<>();
    TreeNode curr = root;

    // traverse the tree
    while (curr != null || s.size() > 0)
    {
      /* Reach the left most Node of the
      curr Node */
      while (curr !=  null)
      {
      /* place pointer to a tree node on
         the stack before traversing
        the node's left subtree */
        s.push(curr);
        curr = curr.left;
      }

      /* Current must be NULL at this point */
      curr = s.pop();

      if((--k)==0){
        break;
      }

      /* we have visited the node and its
         left subtree.  Now, it's right
         subtree's turn */
      curr = curr.right;
    }
    return curr.val;
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
