// https://leetcode.com/problems/largest-rectangle-in-histogram/description/?envType=problem-list-v2&envId=stack

import java.util.Stack;

public class Problem8 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
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
}