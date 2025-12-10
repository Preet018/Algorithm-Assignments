// https://leetcode.com/problems/super-egg-drop/description/?envType=problem-list-v2&envId=dynamic-programming

public class Problem16 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        int m = 0;
        while (dp[k][m] < n) {
            m++;
            for (int i = 1; i <= k; i++) {
                dp[i][m] = dp[i - 1][m - 1] + dp[i][m - 1] + 1;
            }
        }
        return m;
    }
}
