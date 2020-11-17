package com.ds.unionfind;

public class UnionFind {
    private int[] id;
    private int[] sz;
    private boolean[] inUse;

    public UnionFind(int N) {
        id = new int[N];
        sz = new int[N];
        inUse = new boolean[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        inUse[p] = true;
        inUse[q] = true;
        int i = root(p);
        int j = root(q);
        if (i == j) {
            return;
        }

        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }

    public int count() {
        int count = 0;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == i && inUse[i]) {
                count++;
            }
        }
        return count;
    }
}