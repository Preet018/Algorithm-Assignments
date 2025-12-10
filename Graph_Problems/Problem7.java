// https://leetcode.com/problems/is-graph-bipartite/description/?envType=problem-list-v2&envId=depth-first-search

public class Problem7 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                if (!dfs(graph, i, color, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int i, int[] color, int c) {
        color[i] = c;
        for (int neigh : graph[i]) {
            if (color[neigh] == 0) {
                if (!dfs(graph, neigh, color, -c)) {
                    return false;
                }
            } else if (color[neigh] == c) {
                return false;
            }
        }
        return true;
    }
}