package com.leetcode.algorithms.medium;

/*
 * 239. Sliding Window Maximum
 * https://leetcode.com/problems/sliding-window-maximum/
 * Tags: Array, Sliding Window
 * */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Problem239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>(); // max queue

        for (int i = 0; i < nums.length; ++i) {
            while (!q.isEmpty() && q.peekLast() < nums[i]) {
                q.pollLast();
            }
            q.offerLast(nums[i]);
            if (i >= k && nums[i - k] == q.peekFirst()) {// out of bound
                q.pollFirst();
            }
            if (i >= k - 1) {
                ans[i - k + 1] = q.peekFirst();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Problem239().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));//[3,3,5,5,6,7]
    }
}
