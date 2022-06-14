package com.leetcode.algorithms.medium;

/*
 * 99. Recover Binary Search Tree
 * https://leetcode.com/problems/recover-binary-search-tree/
 * Tags: Binary Search Tree (BST)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(Integer[] vals) {
        if (vals.length == 0) {
            left = null;
            right = null;
        }

        val = vals[0];
        left = constructFromArray(vals, 1);
        right = constructFromArray(vals, 2);
    }

    private TreeNode constructFromArray(Integer[] vals, int k) {
        if (k >= vals.length || vals[k] == null) {
            return null;
        }

        TreeNode root = new TreeNode(vals[k]);
        int leftIndex = 2 * k + 1;
        root.left = constructFromArray(vals, leftIndex);

        int rightIndex = 2 * k + 2;
        root.right = constructFromArray(vals, rightIndex);

        return root;
    }

    @Override
    public String toString() {
        return ""+val;
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

public class Problem99 {

    static List<Integer> arr;
    static int i=0;

    public void recoverTree(TreeNode root) {
        arr = new ArrayList<>();
        i = 0;
        dfs(root);
        arr.sort(Comparator.naturalOrder());
        correct(root);
    }

    private void dfs(TreeNode node) {
        if(node == null) {
            return;
        }

        dfs(node.left);
        arr.add(node.val);
        dfs(node.right);
    }

    private void correct(TreeNode node) {
        if(node == null) {
            return;
        }

        correct(node.left);
        node.val = arr.get(i++);
        correct(node.right);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(new Integer[] {3,1,4,null,null,2});
        new Problem99().recoverTree(tree);
        System.out.println(tree.prettyPrint());
    }
}
