package com.insigmaus.algorithm.UF;

public class WeightedQuickUnionUF implements UnionFind{

    private int[] parent;
    private int[] size;
    private int count;
    
    public WeightedQuickUnionUF(int N) {
        parent = new int[N];
        size = new int[N];
        for (int i = 0; i < N; ++i) {
            parent[i] = i;
            size[i] = 1;
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
        while (p != parent[p]) p = parent[p];
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        
        if (rootP > rootQ) {
            parent[rootQ] = rootP;
            size[rootQ] += size[rootP];
        } else {
            parent[rootP] = rootQ;
            size[rootP] += size[rootQ];
        }
        count--;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    
}
