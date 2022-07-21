package com.leetcode.algorithms.hard;

import java.util.ArrayList;
import java.util.*;

/*
 * 297. Serialize and Deserialize Binary Tree
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * Tags: Binary Tree
 * */

public class Problem297 {

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

        public String prettyPrint() {
            StringBuffer sb = new StringBuffer();
            print_r(this, 0, sb);
            return sb.toString();
        }

        private void print_r(TreeNode node, int level, StringBuffer sb) {
            if (node != null) {
                print_r(node.right, level + 1, sb);
                sb.append("\t".repeat(Math.max(0, level)));
                sb.append(node.val);
                sb.append("\n");
                print_r(node.left, level + 1, sb);
            }
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, result);
        StringBuilder sb = new StringBuilder(result.get(0));
        for(int i=1; i<result.size(); i++) {
            sb.append(",");
            sb.append(result.get(i));
        }
        return sb.toString();
    }

    private void dfs(TreeNode node, List<String> result) {
        if(node == null) {
            result.add("N");
            return;
        }
        result.add(String.valueOf(node.val));
        dfs(node.left, result);
        dfs(node.right, result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] preorderNodes = data.split(",");
        return dfs(preorderNodes);
    }

    private int i=0;
    private TreeNode dfs(String[] preorderNodes) {
        if(i >= preorderNodes.length) {
            return null;
        }
        if(preorderNodes[i].equals("N")) {
            i += 1;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(preorderNodes[i]));
        i += 1;
        node.left = dfs(preorderNodes);
        node.right = dfs(preorderNodes);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serializedStr = new Problem297().serialize(root);
        System.out.println(new Problem297().serialize(root));
        System.out.println(new Problem297().deserialize(serializedStr).prettyPrint());
    }
}
