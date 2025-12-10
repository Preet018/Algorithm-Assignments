// https://leetcode.com/problems/detonate-the-maximum-bombs/description/?envType=problem-list-v2&envId=depth-first-search

import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        int count = 1;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(neighbor, adj, visited);
            }
        }
        return count;
    }

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            long r = bombs[i][2];

            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                long x2 = bombs[j][0];
                long y2 = bombs[j][1];

                long dx = x1 - x2;
                long dy = y1 - y2;
                long distSq = dx * dx + dy * dy;

                if (distSq <= r * r) {
                    adj.get(i).add(j);
                }
            }
        }

        int maxDetonated = 0;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            maxDetonated = Math.max(maxDetonated, dfs(i, adj, visited));
        }

        return maxDetonated;
    }
}
