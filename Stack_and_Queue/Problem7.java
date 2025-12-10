// https://leetcode.com/problems/maximal-rectangle/description/?envType=problem-list-v2&envId=stack

import java.util.Stack;

public class Problem7 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int largestRec(int[] heights) {
        int n = heights.length;
        Stack<Integer> stk = new Stack<>();
        int largestRec = 0;
        int Rsmaller = -1;
        int Lsmaller = -1;
        int height = 0;

        for (int i = 0; i <= n; i++) {
            while (!stk.isEmpty() && ((i == n) || heights[stk.peek()] > heights[i])) {
                Rsmaller = i;
                height = heights[stk.pop()];

                if (stk.isEmpty()) {
                    Lsmaller = 0;
                } else {
                    Lsmaller = stk.peek() + 1;
                }
                largestRec = Math.max(largestRec, height * (Rsmaller - Lsmaller));
            }

            stk.push(i);
        }

        return largestRec;
    }

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] heights = new int[m][n];
        int largestRec = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] - '0' == 0) {
                    heights[i][j] = 0;
                } else if (i > 0) {
                    heights[i][j] = heights[i - 1][j] + (matrix[i][j] - '0');
                } else {
                    heights[i][j] = (matrix[i][j] - '0');
                }
            }
        }

        for (int i = 0; i < m; i++) {
            largestRec = Math.max(largestRec, largestRec(heights[i]));
        }

        return largestRec;
    }
}