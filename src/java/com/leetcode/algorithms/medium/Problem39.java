package com.leetcode.algorithms.medium;

import java.util.*;

/*
 * 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/
 * Tags: Backtracking
 * */

public class Problem39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, result, new ArrayList<Integer>(), 0, 0);
        return result;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> currList, int currSum, int i) {
        if(i >= candidates.length || currSum > target) {
            return;
        }
        if(currSum == target) {
            List<Integer> temp = new ArrayList<>();
            for(int j=0; j<currList.size();j++) {
                temp.add(currList.get(j));
            }
            result.add(temp);
            return;
        }

        currList.add(candidates[i]);
        dfs(candidates, target, result, currList, currSum + candidates[i], i);
        currList.remove(currList.size()-1);
        dfs(candidates, target, result, currList, currSum, i+1);
    }

    public static void main(String[] args) {
        System.out.println(new Problem39().combinationSum(new int[]{2,3,6,7}, 7));//[[2,2,3],[7]]
    }
}
