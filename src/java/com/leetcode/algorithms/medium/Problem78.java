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

  //Todo - Remove few duplicates
  /*public List<List<Integer>> subsets(int[] nums) {
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
  }*/

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
    //System.out.println(problem78.subsets(nums));//Incorrect
    System.out.println(problem78.subsetsIterative(nums));
  }
}
