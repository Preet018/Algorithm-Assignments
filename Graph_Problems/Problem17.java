// https://leetcode.com/problems/minimum-cost-to-convert-string-i/description/?envType=problem-list-v2&envId=shortest-path

import java.util.Arrays;

public class Problem17 {
    public static void main(String[] args) {

    }
}

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] mat = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(mat[i], Integer.MAX_VALUE);
            mat[i][i] = 0;
        }

        for (int i = 0; i < cost.length; i++) {
            mat[original[i] - 'a'][changed[i] - 'a'] = Math.min(cost[i], mat[original[i] - 'a'][changed[i] - 'a']);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (mat[i][k] == Integer.MAX_VALUE || mat[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }

                    mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                }
            }
        }

        long res = 0;
        for (int i = 0; i < source.length(); i++) {
            if (mat[source.charAt(i) - 'a'][target.charAt(i) - 'a'] == Integer.MAX_VALUE) {
                return (long) -1;
            } else {
                res += mat[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
            }
        }
        return res;
    }
}