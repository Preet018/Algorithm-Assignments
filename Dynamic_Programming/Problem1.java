// https://leetcode.com/problems/01-matrix/description/?envType=problem-list-v2&envId=dynamic-programming

import java.util.LinkedList;
import java.util.Queue;

public class Problem1 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    que.offer(new int[] { i, j, 0 });
                    visited[i][j] = true;
                }
            }
        }

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (!que.isEmpty()) {
            int[] cell = que.poll();
            int i = cell[0], j = cell[1], dis = cell[2];
            res[i][j] = dis;

            for (int[] dir : directions) {
                int newR = i + dir[0];
                int newC = j + dir[1];

                // Check bounds and visited status
                if (newR >= 0 && newR < m && newC >= 0 && newC < n && !visited[newR][newC]) {
                    visited[newR][newC] = true;
                    // Enqueue the neighbor with incremented distance
                    que.offer(new int[] { newR, newC, dis + 1 });
                }
            }
        }
        return res;
    }
}