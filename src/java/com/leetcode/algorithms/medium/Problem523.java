package com.leetcode.algorithms.medium;

import java.util.HashMap;
import java.util.Map;

/*
 * 523. Continuous Subarray Sum
 * https://leetcode.com/problems/continuous-subarray-sum/
 * Tags: Array, Hash Map
 */

public class Problem523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, -1);

        int sum = 0;
        for(int i=0;i < nums.length;i++){
            sum += nums[i];
            int m = sum % k;
            if(cache.containsKey(m)) {
                if(i-cache.get(m) > 1) {
                    return true;
                }
            } else {
                cache.put(m, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Problem523().checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));//true
        System.out.println(new Problem523().checkSubarraySum(new int[]{23,2,6,4,7}, 6));//true
        System.out.println(new Problem523().checkSubarraySum(new int[]{23,2,6,4,7}, 13));//false
    }
}
