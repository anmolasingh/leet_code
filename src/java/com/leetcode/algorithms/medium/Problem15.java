package com.leetcode.algorithms.medium;

/*
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/
 * Tags: Array, Sliding Window
 * */

import java.util.*;

public class Problem15 {

    //Sliding window
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length <=2) {
            return result;
        }

        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            if(i != 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int l = i+1, r = nums.length-1;
            while(l < r) {
                int threeSum = nums[i] + nums[l] + nums[r];
                if(threeSum == 0) {
                    List<Integer> currResult = new ArrayList<>();
                    currResult.add(nums[i]);
                    currResult.add(nums[l]);
                    currResult.add(nums[r]);
                    result.add(currResult);
                    l+=1;
                    while(nums[l] == nums[l-1] && l<r) {
                        l+=1;
                    }
                } else if(threeSum > 0) {
                    r-=1;
                } else {
                    l+=1;
                }
            }
        }
        return result;
    }

    //Hash set
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length <=2) {
            return result;
        }

        Set<String> alreadyPresent = new HashSet<>();

        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            if(i != 0 && nums[i] == nums[i-1]) {
                continue;
            }

            Set<Integer> set = new HashSet<>();
            for(int j=i+1; j<nums.length; j++) {
                int diff = 0 - nums[i] - nums[j];
                if(set.contains(diff)) {
                    String check = nums[i] + ":" + nums[j] + ":" + diff;
                    if(!alreadyPresent.contains(check)) {
                        List<Integer> currResult = new ArrayList<>();
                        currResult.add(nums[i]);
                        currResult.add(nums[j]);
                        currResult.add(diff);
                        result.add(currResult);
                        alreadyPresent.add(check);
                    }
                }
                set.add(nums[j]);
            }
        }
        return result;
    }

    private boolean isSumZero(int[] nums) {
        int sum=0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        return sum == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Problem15().threeSum(new int[]{-1,0,1,2,-1,-4}));//[[-1,1,0],[-1,2,-1]]
        System.out.println(new Problem15().threeSum(new int[]{}));//[]
        System.out.println(new Problem15().threeSum(new int[]{0,0}));//[]
        System.out.println(new Problem15().threeSum(new int[]{0,0,0}));//[[0,0,0]]
        System.out.println(new Problem15().threeSum(new int[]{0,0,0,0}));//[[0,0,0]]
    }
}
