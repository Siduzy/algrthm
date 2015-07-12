package com.insigmaus.algorithm.UF;

public class QuickFindUF implements UnionFind {

    private int[] ids;
    private int count;

    public QuickFindUF(int n) {
        ids = new int[n];
        count = n;
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
        }
    }

    private void validate(int p) {
        if (p < 0 || p >= ids.length) {
            throw new IndexOutOfBoundsException();
        }
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        validate(p);
        return ids[p];
    }

    public void union(int p, int q) {
        if (connected(p, q))
            return;
        int valToReplace = ids[q];
        for (int i = 0; i < ids.length; ++i)
            if (ids[i] == valToReplace)ids[i] = ids[p];

        count--;
    }

    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return ids[p] == ids[q];
    }
}
