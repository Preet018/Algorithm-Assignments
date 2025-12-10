// https://leetcode.com/problems/matchsticks-to-square/description/?envType=problem-list-v2&envId=bitmask

public class Problem21 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;

        for (int i = 0; i < matchsticks.length; i++) {
            sum += matchsticks[i];
        }

        if (sum % 4 != 0) {
            return false;
        }

        int div = sum / 4;
        boolean[] check = new boolean[matchsticks.length];

        if (backtrack(0, matchsticks, div, check, 0, 0)) {
            return true;
        }

        return false;
    }

    public boolean backtrack(int index, int[] match, int div, boolean[] check, int total, int x) {
        if (x == 3) {
            return true;
        }

        if (total == div) {
            return backtrack(0, match, div, check, 0, x + 1);
        }
        for (int i = index; i < match.length; i++) {
            if (!check[i]) {
                check[i] = true;
                total += match[i];

                if (total <= div && backtrack(i + 1, match, div, check, total, x)) {
                    return true;
                }

                check[i] = false;
                total -= match[i];
            }
        }

        return false;
    }
}