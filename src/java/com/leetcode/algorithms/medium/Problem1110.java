package com.leetcode.algorithms.medium;

/*
 * 1110. Delete Nodes And Return Forest
 * https://leetcode.com/problems/delete-nodes-and-return-forest/
 * Tags: Tree, Binary Tree
 * */

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem1110 {

  static class TreeNode {

    int val;
    Problem1110.TreeNode left;
    Problem1110.TreeNode right;

    TreeNode(int x) {
      val = x;
    }

    @Override
    public String toString() {
      return String.valueOf(val) + (left != null ? " " + left : "") + (right != null ? " " + right
          : "");
    }
  }

  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    Set<TreeNode> allTreeRoots = new HashSet<>();
    allTreeRoots.add(root);

    for (int i = 0; i < to_delete.length; i++) {
      int num = to_delete[i];
      TreeNode node;
      TreeNode parent = findParent(allTreeRoots, num);
      if (parent == null) {
        node = findNode(allTreeRoots, num);
        moveChildren(allTreeRoots, node);
        allTreeRoots.remove(node);
      } else {
        if (parent.left != null && parent.left.val == num) {
          node = parent.left;
          moveChildren(allTreeRoots, node);
          parent.left = null;
        } else if (parent.right != null && parent.right.val == num) {
          node = parent.right;
          moveChildren(allTreeRoots, node);
          parent.right = null;
        }
      }
    }

    return allTreeRoots.stream().distinct().collect(Collectors.toList());
  }

  private void moveChildren(Set<TreeNode> allTreeRoots, TreeNode node) {
    if (node.left != null) {
      allTreeRoots.add(node.left);
    }
    if (node.right != null) {
      allTreeRoots.add(node.right);
    }
  }

  private TreeNode findNode(Set<TreeNode> allTreeRoots, int i) {
    for (TreeNode root : allTreeRoots) {
      TreeNode node = findNode(root, i);
      if (node != null) {
        return node;
      }
    }
    return null;
  }

  private TreeNode findNode(TreeNode node, int i) {
    if (node == null) {
      return null;
    }

    if (node.val == i) {
      return node;
    }

    TreeNode left = findNode(node.left, i);
    if (left != null) {
      return left;
    }

    TreeNode right = findNode(node.right, i);
    if (right != null) {
      return right;
    }
    return null;
  }

  private TreeNode findParent(Set<TreeNode> allTreeRoots, int i) {
    for (TreeNode root : allTreeRoots) {
      TreeNode node = findParent(root, null, i);
      if (node != null) {
        return node;
      }
    }
    return null;
  }

  private TreeNode findParent(TreeNode node, TreeNode parent, int i) {
    if (node == null) {
      return null;
    }

    if (node.val == i) {
      return parent;
    }

    TreeNode left = findParent(node.left, node, i);
    if (left != null) {
      return left;
    }

    TreeNode right = findParent(node.right, node, i);
    if (right != null) {
      return right;
    }
    return null;
  }

  public static void main(String[] args) {
    Problem1110.TreeNode root = new Problem1110.TreeNode(1);
    root.left = new Problem1110.TreeNode(2);
    root.right = new Problem1110.TreeNode(3);
    root.left.left = new Problem1110.TreeNode(4);
    root.left.right = new Problem1110.TreeNode(5);
    root.right.left = new Problem1110.TreeNode(6);
    root.right.right = new Problem1110.TreeNode(7);
    int toDelete[] = {1, 6, 2};
    System.out
        .println(new Problem1110().delNodes(root, toDelete));
  }

}
