package com.leetcode.algorithms.medium;

/*
 * 230. Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * Tags: Trees
 * */

import java.util.PriorityQueue;

public class Problem230 {

  public int kthSmallest(TreeNode root, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    dfs(root, heap, k);
    int result = 0;
    while(!heap.isEmpty()) {
      result = heap.poll();
    }
    return result;
  }

  private void dfs(TreeNode node, PriorityQueue<Integer> heap, int k) {
    if(node == null) {
      return;
    }

    dfs(node.left, heap, k);
    if(heap.size() == k) {
      return;
    }
    heap.add(node.val);
    dfs(node.right, heap, k);
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
