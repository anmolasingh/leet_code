package com.leetcode.algorithms.medium;

/*
 * 740. Delete and Earn
 * https://leetcode.com/problems/delete-and-earn/
 * Tags: Dynamic Programming
 * */

import java.util.*;
import java.util.stream.Collectors;

public class Problem740 {

    public int deleteAndEarn(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        Map<Integer, Integer> countMap = new TreeMap<>();
        Arrays.stream(nums).forEach(n -> {
            int v = countMap.getOrDefault(n, 0);
            countMap.put(n, v+1);
        });
        List<Integer> reducedList = countMap.keySet().stream().collect(Collectors.toList());

        int cache[] = new int[reducedList.size()];
        cache[0] = reducedList.get(0) * countMap.get(reducedList.get(0));
        for (int i = 1; i < reducedList.size(); i++) {
            int v = reducedList.get(i) * countMap.get(reducedList.get(i));
            if(reducedList.get(i-1) + 1 != reducedList.get(i)){
                v += cache[i-1];
            } else if(i-2 >= 0) {
                v += cache[i-2];
            }
            cache[i] = Math.max(cache[i-1], v);
        }
        //System.out.println(Arrays.toString(cache));
        return cache[reducedList.size()-1];
    }

    public static void main(String[] args) {
        Problem740 problem740 = new Problem740();
        System.out.println(problem740.deleteAndEarn(new int[]{2,2,3,3,3,4}));
        System.out.println(problem740.deleteAndEarn(new int[]{3,4,2}));
        System.out.println(problem740.deleteAndEarn(new int[]{3,4,2,2,2,2,2,2,6,9,1,1000,2,1000}));
    }
}
