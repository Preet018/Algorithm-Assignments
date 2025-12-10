// https://leetcode.com/problems/remove-k-digits/?envType=problem-list-v2&envId=stack

import java.util.Stack;

public class Problem2 {
    public static void main(String[] args) {

    }
}

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stk = new Stack<>();
        int n = num.length();

        for (int i = 0; i < n; i++) {
            if (k == 0) {
                stk.push(num.charAt(i));
                continue;
            }

            while (k > 0 && !stk.isEmpty() && num.charAt(i) < stk.peek()) {
                stk.pop();
                k--;
            }
            stk.push(num.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        while (k > 0 && !stk.isEmpty()) {
            stk.pop();
            k--;
        }

        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        sb.reverse();
        String ans = sb.toString().replaceFirst("^0+(?!$)", "");

        return ans.equals("") ? "0" : ans;
    }
}