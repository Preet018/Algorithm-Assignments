// https://leetcode.com/problems/inverse-coin-change/description/?envType=problem-list-v2&envId=dynamic-programming

import java.util.ArrayList;
import java.util.List;

public class Problem11 {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<Integer> findCoins(int[] numWays) {
        int n = numWays.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 0; i < n; ++i) {
            dp[i + 1] = numWays[i];
        }

        List<Integer> res = new ArrayList<>();
        for (int a = 1; a <= n; ++a) {
            if (dp[a] > 1)
                return new ArrayList<>();
            if (dp[a] == 0)
                continue;
            res.add(a);
            for (int v = n; v >= a; --v) {
                dp[v] -= dp[v - a];
                if (dp[v] < 0)
                    return new ArrayList<>();
            }
        }

        return res;
    }
}