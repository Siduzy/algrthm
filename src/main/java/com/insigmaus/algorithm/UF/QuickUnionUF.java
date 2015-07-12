package com.insigmaus.algorithm.UF;

public class QuickUnionUF implements UnionFind{

    private int[] parent;
    private int count;
    
    public QuickUnionUF(int N) {
        parent = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }
    
    private void validate(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IndexOutOfBoundsException();
        }
    }
    
    public int count() {
        return count;
    }
    
    public int find(int p) {
        validate(p);
        int i = p;
        while (parent[i] != i) i = parent[i];
        return i;
    }

    public void union(int p, int q) {
        if (connected(p, q)) return;
        int pRoot = find(p);
        int qRoot = find(q);
        parent[pRoot] = qRoot;
        count--;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}
