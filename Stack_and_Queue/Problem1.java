// https://leetcode.com/problems/validate-stack-sequences/description/?envType=problem-list-v2&envId=stack

import java.util.Stack;

public class Problem1 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack<>();
        int n = pushed.length;
        int m = popped.length;
        int i = 0;
        int j = 0;

        while (i < n) {
            stk.push(pushed[i]);
            while (j < m && !stk.isEmpty() && popped[j] == stk.peek()) {
                stk.pop();
                j++;
            }
            i++;
        }

        return stk.isEmpty();
    }
}