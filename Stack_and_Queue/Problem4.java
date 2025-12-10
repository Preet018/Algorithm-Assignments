// https://leetcode.com/problems/132-pattern/description/?envType=problem-list-v2&envId=stack

import java.util.Stack;

public class Problem4 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int numj = Integer.MIN_VALUE;
        Stack<Integer> stk = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < numj) {
                return true;
            }

            while (!stk.isEmpty() && nums[i] > stk.peek()) {
                numj = stk.pop();
            }
            stk.push(nums[i]);
        }

        return false;
    }
}