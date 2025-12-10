// https://leetcode.com/problems/2-keys-keyboard/description/?envType=problem-list-v2&envId=dynamic-programming

public class Problem5 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minSteps(int n) {
        if (n == 1)
            return 0;

        int steps = 0;
        int factor = 2;

        while (n > 1) {
            while (n % factor == 0) {
                steps += factor;
                n /= factor;
            }
            factor++;
        }

        return steps;
    }
}