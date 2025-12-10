// https://leetcode.com/problems/palindrome-partitioning-ii/description/?envType=problem-list-v2&envId=dynamic-programming

public class Problem13 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int[] minCuts = new int[n];

        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) &&
                        (end - start <= 2 || isPalindrome[start + 1][end - 1])) {
                    isPalindrome[start][end] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (isPalindrome[0][i]) {
                minCuts[i] = 0;
            } else {
                int min = i;
                for (int j = 0; j < i; j++) {
                    if (isPalindrome[j + 1][i]) {
                        min = Math.min(min, minCuts[j] + 1);
                    }
                }
                minCuts[i] = min;
            }
        }

        return minCuts[n - 1];
    }
}