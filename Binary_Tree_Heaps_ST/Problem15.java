// https://leetcode.com/problems/sum-in-a-matrix/description/?envType=problem-list-v2&envId=heap-priority-queue

import java.util.Arrays;

public class Problem15 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int matrixSum(int[][] nums) {
        int m = nums.length;
        if (m == 0)
            return 0;
        int n = nums[0].length;
        int total = 0;

        for (int[] row : nums) {
            Arrays.sort(row);
        }

        for (int col = 0; col < n; col++) {
            int best = 0;
            for (int row = 0; row < m; row++) {
                best = Math.max(best, nums[row][col]);
            }
            total += best;
        }
        return total;
    }
}