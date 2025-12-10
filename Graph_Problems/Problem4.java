// https://leetcode.com/problems/water-and-jug-problem/description/?envType=problem-list-v2&envId=depth-first-search

import java.util.LinkedList;
import java.util.Queue;

public class Problem4 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if (target > x + y)
            return false;
        if (target == 0)
            return true;
        if (x == 0)
            return target == y;
        if (y == 0)
            return target == x;

        boolean[][] vis = new boolean[x + 1][y + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] state = q.poll();
            int a = state[0], b = state[1];
            if (a + b == target)
                return true;

            int[][] next = {
                    { x, b }, { a, y }, { 0, b }, { a, 0 },
                    { a - Math.min(a, y - b), b + Math.min(a, y - b) },
                    { a + Math.min(b, x - a), b - Math.min(b, x - a) }
            };
            for (int[] nxt : next) {
                if (!vis[nxt[0]][nxt[1]]) {
                    vis[nxt[0]][nxt[1]] = true;
                    q.add(nxt);
                }
            }
        }
        return false;
    }
}