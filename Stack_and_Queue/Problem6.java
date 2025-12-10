// https://leetcode.com/problems/next-greater-element-ii/description/?envType=problem-list-v2&envId=stack

import java.util.Stack;

public class Problem6 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stk = new Stack<>();

        for (int j = 0; j < 2; j++) {
            for (int i = n - 1; i >= 0; i--) {
                while (!stk.isEmpty() && stk.peek() <= nums[i]) {
                    stk.pop();
                }

                if (stk.isEmpty()) {
                    ans[i] = -1;
                } else {
                    ans[i] = stk.peek();
                }

                stk.push(nums[i]);
            }
        }

        return ans;
    }
}