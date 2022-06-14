package com.leetcode.algorithms.medium;

/*
 * 78. Subsets
 * https://leetcode.com/problems/subsets/
 * Tags: Backtracking
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem78 {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<Integer>());
    dfs(nums, result, new ArrayList<Integer>(), 0);
    return result;
  }

  private void dfs(int[] nums, List<List<Integer>> result, List<Integer> currList, int index) {
    if (index == nums.length) {
      return;
    }
    List<Integer> newList = new ArrayList<>(currList);
    newList.add(nums[index]);
    result.add(newList);
    dfs(nums, result, currList, index+1);
    dfs(nums, result, newList, index+1);
  }

  public List<List<Integer>> subsetsIterative(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<Integer>());
    for(int i=0; i<nums.length; ++i) {
      List<List<Integer>> temp1 = new ArrayList<>();
      for(int j=0;j<result.size(); ++j) {
        List<Integer> temp = result.get(j).stream().collect(Collectors.toList());
        temp.add(nums[i]);
        temp1.add(temp);
      }

      temp1.stream().forEach(l -> {
        result.add(l);
      });
    }
    return result;
  }

  public static void main(String[] args) {
    Problem78 problem78 = new Problem78();
    int nums[] = {1, 2, 3};
    System.out.println(problem78.subsets(nums));//[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    System.out.println(problem78.subsetsIterative(nums));//[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
  }
}
