// https://leetcode.com/problems/couples-holding-hands/description/?envType=problem-list-v2&envId=union-find

public class Problem22 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        DisjointSet ds = new DisjointSet(n);

        for (int i = 0; i < n; i += 2)
            ds.union(i, i + 1);

        int minSwap = 0;

        for (int i = 0; i < n; i += 2) {
            minSwap += ds.union(row[i], row[i + 1]);
        }
        return minSwap;
    }
}

class DisjointSet {
    int size[], parent[];

    public DisjointSet(int n) {
        size = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }

    public int union(int u, int v) {
        int pv = find(v);
        int pu = find(u);

        if (pu == pv)
            return 0;
        else if (size[pu] >= size[pv]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        } else {
            parent[pu] = pv;
            size[pv] += size[pu];
        }
        return 1;
    }
}