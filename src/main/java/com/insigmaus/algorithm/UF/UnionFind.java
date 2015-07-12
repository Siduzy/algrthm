package com.insigmaus.algorithm.UF;

public interface UnionFind {
    public int count();
    public int find(int t);
    public void union(int p, int q);
    public boolean connected(int p, int q);
}
