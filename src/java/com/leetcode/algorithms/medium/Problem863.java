package com.leetcode.algorithms.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Problem863 {

  static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    List<Integer> result = new ArrayList<>();
    if(root == null || target == null || K < 0){
      return result;
    }

    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    createParentMap(root, parentMap);

    Set<TreeNode> seenSet = new HashSet<>();

    //perform BFS
    Queue<TreeNode> bfsQueue1 = new LinkedList<>();
    Queue<TreeNode> bfsQueue2 = new LinkedList<>();

    bfsQueue1.add(target);
    int currDistance = 0;
    while (!bfsQueue1.isEmpty() || !bfsQueue2.isEmpty()) {
      if (!bfsQueue1.isEmpty()) {

        while (!bfsQueue1.isEmpty()) {
          TreeNode currElement = bfsQueue1.poll();
          if(seenSet.contains(currElement)){
            continue;
          }

          if (currDistance == K) {
            result.add(currElement.val);
          } else {
            if (currElement.left != null) {
              bfsQueue2.add(currElement.left);
            }
            if (currElement.right != null) {
              bfsQueue2.add(currElement.right);
            }
            TreeNode parent = parentMap.get(currElement);
            if(parent != null){
              bfsQueue2.add(parent);
            }
          }
          seenSet.add(currElement);
        }
      } else if (!bfsQueue2.isEmpty()) {
        while (!bfsQueue2.isEmpty()) {
          TreeNode currElement = bfsQueue2.poll();
          if(seenSet.contains(currElement)){
            continue;
          }
          if (currDistance == K) {
            result.add(currElement.val);
          } else {
            if (currElement.left != null) {
              bfsQueue1.add(currElement.left);
            }
            if (currElement.right != null) {
              bfsQueue1.add(currElement.right);
            }
            TreeNode parent = parentMap.get(currElement);
            if(parent != null){
              bfsQueue1.add(parent);
            }
          }
          seenSet.add(currElement);
        }
      }
      currDistance++;
    }

    return result;
  }

  private void createParentMap(TreeNode node, Map<TreeNode, TreeNode> parentMap) {
    if(node == null){
      return;
    }

    if(node.left != null){
      parentMap.put(node.left, node);
      createParentMap(node.left, parentMap);
    }
    if(node.right != null){
      parentMap.put(node.right, node);
      createParentMap(node.right, parentMap);
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(5);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(2);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(8);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(4);
    System.out.println(new Problem863().distanceK(root, root.left, 2));
  }
}
