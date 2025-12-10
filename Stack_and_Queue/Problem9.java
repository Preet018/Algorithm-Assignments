// https://leetcode.com/problems/trapping-rain-water/description/?envType=problem-list-v2&envId=stack

import java.util.Stack;

public class Problem9 {
    public static void main(String[] args) {

    }
}

class Solution {
    public long maximumSumOfHeights(int[] heights) {
        int n = heights.length;
        long maxSum = 0;

        // iterating through each element, assuming it's peak
        for (int max = 0; max < n; max++) {
            long sum = heights[max];
            Stack<Integer> stk = new Stack<>();

            stk.push(heights[max]);
            for (int i = max - 1; i >= 0; i--) {
                stk.push(Math.min(heights[i], stk.peek()));
                sum += stk.peek();
            }

            // Time complexity - O(1)
            stk.empty();
            stk.push(heights[max]);

            for (int i = max + 1; i < n; i++) {
                stk.push(Math.min(stk.peek(), heights[i]));
                sum += stk.peek();
            }

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}