// https://leetcode.com/problems/partition-array-for-maximum-sum/description/?envType=problem-list-v2&envId=dynamic-programming

import java.util.Arrays;

public class Problem8 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int N = arr.length;
        int K = k + 1;

        int[] dp = new int[K];
        Arrays.fill(dp, 0);

        for (int start = N - 1; start >= 0; start--) {
            int currMax = 0;
            int end = Math.min(N, start + k);

            for (int i = start; i < end; i++) {
                currMax = Math.max(currMax, arr[i]);
                dp[start % K] = Math.max(dp[start % K], dp[(i + 1) % K] + currMax * (i - start + 1));
            }
        }
        return dp[0];
    }
}