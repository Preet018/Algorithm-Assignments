// https://leetcode.com/problems/redundant-connection-ii/description/?envType=problem-list-v2&envId=union-find

import java.util.Arrays;

public class Problem19 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {

        int[] result = new int[2];

        int blackList1 = -1;
        int blackList2 = -1;

        int[] indegree = new int[edges.length + 1];
        Arrays.fill(indegree, -1);
        for (int i = 0; i < edges.length; i++) {
            if (indegree[edges[i][1]] != -1) {
                blackList1 = i;
                blackList2 = indegree[edges[i][1]];
            }

            indegree[edges[i][1]] = i;
        }

        boolean hasCycle = false;
        int[] parent = new int[edges.length + 1];
        Arrays.fill(parent, -1);

        for (int i = 0; i < edges.length; i++) {

            if (i == blackList1)
                continue;

            int u = edges[i][0];
            int v = edges[i][1];

            int setU = findSet(u, parent);
            int setV = findSet(v, parent);

            if (setU == setV) {
                if (blackList1 == -1) {
                    result[0] = u;
                    result[1] = v;
                    return result;
                }
                hasCycle = true;
                break;
            }

            parent[setU] = setV;
        }

        if (!hasCycle) {
            result[0] = edges[blackList1][0];
            result[1] = edges[blackList1][1];
        } else {
            result[0] = edges[blackList2][0];
            result[1] = edges[blackList2][1];
        }

        return result;
    }

    private int findSet(int u, int[] parent) {
        if (parent[u] == -1)
            return u;
        return findSet(parent[u], parent);
    }
}