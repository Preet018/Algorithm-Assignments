// https://takeuforward.org/data-structure/number-of-longest-increasing-subsequences-dp-47/

import java.util.*;

public class Problem24 {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 4, 3, 2, 6, 7, 2 };
        Solution sol = new Solution();
        System.out.println("The count of Longest Increasing Subsequences (LIS) is "
                + sol.findNumberOfLIS(arr));
    }
}

class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] ct = new int[n];
        Arrays.fill(ct, 1);
        int maxi = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    ct[i] = ct[j];
                } else if (arr[j] < arr[i] && dp[j] + 1 == dp[i]) {
                    ct[i] = ct[i] + ct[j];
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        int countLIS = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxi) {
                countLIS += ct[i];
            }
        }
        return countLIS;
    }
}