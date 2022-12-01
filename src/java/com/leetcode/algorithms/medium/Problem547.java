package com.leetcode.algorithms.medium;

/*
 * 547. Number of Provinces
 * https://leetcode.com/problems/number-of-provinces/
 * Tags: Union Find
 * */

public class Problem547 {

    int[] uf;
    int[] rank;
    int N;
    public int findCircleNum(int[][] isConnected) {
        N = isConnected.length;
        uf = new int[N];
        rank = new int[N];
        for(int i=0; i<N; i++) {
            uf[i] = i;
            rank[i] = 1;
        }
        int numOfProvinces = N;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(isConnected[i][j] == 1) {
                    int p1 = find(i);
                    int p2 = find(j);
                    if(p1 != p2) {
                        union(p1, p2);
                        numOfProvinces--;
                    }
                }
            }
        }
        return numOfProvinces;
    }

    private int find(int i) {
        while(i != uf[i]) {
            uf[i] = uf[uf[i]];
            i = uf[i];
        }
        return i;
    }

    private void union(int p1, int p2) {
        if(rank[p2] > rank[p1]) {
            uf[p1] = p2;
            rank[p2] += rank[p1];
        } else {
            uf[p2] = p1;
            rank[p1] += rank[p2];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem547().findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));//2
    }
}
