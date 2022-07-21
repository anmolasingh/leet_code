package com.leetcode.algorithms.medium;

import java.util.stream.IntStream;

/*
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Tags: Binary Tree
 * */

public class Problem105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int mid = IntStream.range(0, preorder.length)
                .filter(i -> preorder[0] == inorder[i])
                .findFirst()
                .orElse(-1);
        root.left = buildTree(subArray(preorder, 1, mid+1), subArray(inorder, 0, mid));
        root.right = buildTree(subArray(preorder, mid+1, preorder.length), subArray(inorder, mid+1, inorder.length));
        return root;
    }

    private int[] subArray(int[] a, int l, int r){
        int result[] = new int[r-l];
        int ri = 0;
        for(int i=l; i<r;i++){
            result[ri] = a[i];
            ri++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem105().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}).prettyPrint());
    }
}
