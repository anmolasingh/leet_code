package com.lintcode.algorithms.medium;

/*
 * 515 · Paint House
 * https://www.lintcode.com/problem/515/
 * Tags: Dynamic Programming
 * */

public class Problem515 {

    //Approach: Iterative
    public int minCost(int[][] costs) {
        int cache[] = {0,0,0};
        for(int i=0; i<costs.length; i++) {
            int dp0 = costs[i][0] + Math.min(cache[1], cache[2]);
            int dp1 = costs[i][1] + Math.min(cache[0], cache[2]);
            int dp2 = costs[i][2] + Math.min(cache[0], cache[1]);
            cache[0] = dp0;
            cache[1] = dp1;
            cache[2] = dp2;
        }
        return Math.min(cache[0], Math.min(cache[1], cache[2]));
    }

    //Approach: Recursive
    /*public int minCost(int[][] costs) {
        return dfs(costs, 0, -1, new int[costs.length][3]);
    }*/

    private int dfs(int[][] costs, int houseIndex, int previousColorIndex, int[][] cache) {
        if(houseIndex >= costs.length){
            return 0;
        }

        int minCost = Integer.MAX_VALUE;
        for(int c=0; c<3;c++){
            if(c != previousColorIndex) {
                int currCost;
                if(cache[houseIndex][c] != 0){
                    currCost = cache[houseIndex][c];
                } else {
                    currCost =  costs[houseIndex][c] + dfs(costs, houseIndex + 1, c, cache);
                }
                cache[houseIndex][c] = currCost;
                minCost = Math.min(minCost, currCost);
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        int costs1[][] = {{14,2,11},{11,14,5},{14,3,10}};
        System.out.println(new Problem515().minCost(costs1));//10
        int costs2[][] = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(new Problem515().minCost(costs2));//10
    }
}
