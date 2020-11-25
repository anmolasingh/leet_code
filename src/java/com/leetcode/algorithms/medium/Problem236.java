package com.leetcode.algorithms.medium;

/*
 * 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Tags: Tree, Binary Tree
 * */

import java.util.List;

public class Problem236 {

  static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  //Recursive approach
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    return checkNode(root, p, q);
  }

  private TreeNode checkNode(TreeNode node, TreeNode p, TreeNode q) {
    if(node == null){
      return null;
    }

    if(node.val == p.val || node.val == q.val){
      return node;
    }

    TreeNode left = checkNode(node.left, p, q);
    TreeNode right = checkNode(node.right, p, q);
    if(left!= null && right != null){
      return node;
    }else if(left != null){
      return  left;
    }else if(right != null){
      return right;
    }
    return null;
  }

  //Array approach
  /*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    List<TreeNode> arr1 = new ArrayList<>();
    List<TreeNode> arr2 = new ArrayList<>();
    hasPath(root, arr1, p.val);
    hasPath(root, arr2, q.val);

    int index1 = 0, index2 = 0;
    TreeNode result = null;
    while (index1 < arr1.size() && index2 < arr2.size()){
      TreeNode node1 = arr1.get(index1);
      TreeNode node2 = arr2.get(index2);
      if(node1.val == node2.val){
        result = node1;
      }
      index1++;
      index2++;
    }

    return result;
  }*/

  public static boolean hasPath(TreeNode node, List<TreeNode> arr, int x) {
    // if root is NULL
    // there is no path
    if (node == null) {
      return false;
    }

    // push the node's value in 'arr'
    arr.add(node);

    // if it is the required node
    // return true
    if (node.val == x) {
      return true;
    }

    // else check whether the required node lies
    // in the left subtree or right subtree of
    // the current node
    if (hasPath(node.left, arr, x) ||
        hasPath(node.right, arr, x)) {
      return true;
    }

    // required node does not lie either in the
    // left or right subtree of the current node
    // Thus, remove current node's value from
    // 'arr' and then return false
    arr.remove(arr.size()-1);
    return false;
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
        .println(new Problem236().lowestCommonAncestor(root, root.left, root.left.right.right).val);
  }

}
