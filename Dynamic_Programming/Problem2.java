// https://leetcode.com/problems/delete-operation-for-two-strings/description/?envType=problem-list-v2&envId=dynamic-programming

public class Problem2 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int t[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        int lcs = t[m][n];
        int del = m - lcs, ins = n - lcs;
        return del + ins;
    }
}