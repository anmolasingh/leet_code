package com.leetcode.algorithms.medium;

/*
 * 46. Permutations
 * https://leetcode.com/problems/permutations/
 * Tags: Backtracking
 * */

import java.util.ArrayList;
import java.util.List;

public class Problem46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> currList, int nums[]){
        if(currList.size() == nums.length){
            list.add(currList);
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(!currList.contains(nums[i])) {
                List<Integer> localList = new ArrayList<>(currList);
                localList.add(nums[i]);
                backtrack(list, localList, nums);
            }
        }
    }

    public static void main(String[] args) {
        Problem46 problem46 = new Problem46();
        int nums[] = {1,2,3};
        System.out.println(problem46.permute(nums));
    }
}
