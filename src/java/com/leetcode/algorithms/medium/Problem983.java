package com.leetcode.algorithms.medium;

/*
 * 983. Minimum Cost For Tickets
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 * Tags: Dynamic Programming
 * */

import java.util.Arrays;

public class Problem983 {

    //Approach 1 - Iterative
    /*public int mincostTickets(int[] days, int[] costs) {
        int week = 0;
        int month = 0;
        int[] dp = new int[days.length + 1];
        dp[0] = 0;
        for (int i = 0; i < days.length; i++) {
            while (days[week] < days[i] - 6) {
                week++;
            }
            while (days[month] < days[i] - 29) {
                month++;
            }
            int tmp = Math.min(dp[i] + costs[0], dp[week] + costs[1]);
            dp[i + 1] = Math.min(tmp, dp[month] + costs[2]);
        }
        return dp[days.length];
    }*/

    //Approach 2 - Recursive
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, -1);
        int result = dfs(0, dp, days, new int[]{1, 7, 30}, costs);
        System.out.println(Arrays.toString(dp));
        return result;
    }

    private int dfs(int index, int[] dp, int[] days, int[] intervals, int[] costs) {
        if(index == days.length) {
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }

        dp[index] = Integer.MAX_VALUE;
        for(int i=0; i<intervals.length; i++){
            int j = index;
            int maxFutureDays = days[index] + intervals[i];
            while(j < days.length && days[j] < maxFutureDays) {
                j++;
            }
            dp[index] = Math.min(dp[index], costs[i] + dfs(j, dp, days, intervals, costs));
        }
        return dp[index];
    }

    public static void main(String[] args) {
        Problem983 problem983 = new Problem983();
        System.out.println(problem983.mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));
        System.out.println(problem983.mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2,7,15}));
    }
}
