package com.leetcode.algorithms.medium;

/*
 * 78. Subsets
 * https://leetcode.com/problems/subsets/
 * Tags: Backtracking
 * */

import java.util.ArrayList;
import java.util.List;

public class Problem78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> currList, int[] nums, int index) {
        list.add(currList);
        if (currList.size() == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (!currList.contains(nums[i])) {
                List<Integer> localList = new ArrayList<>(currList);
                localList.add(nums[i]);
                backtrack(list, localList, nums, index++);
            }
        }
    }

    public static void main(String[] args) {
        Problem78 problem78 = new Problem78();
        int nums[] = {1, 2, 3};
        System.out.println(problem78.subsets(nums));
    }
}
