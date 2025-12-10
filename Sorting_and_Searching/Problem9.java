// https://leetcode.com/problems/global-and-local-inversions/description/

public class Problem9 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;

        // if a number is moves >1 place it's gonna create global pair...
        for (int i = 0; i < n; i++) {
            if (Math.abs(nums[i] - i) > 1) {
                return false;
            }
        }

        return true;
    }
}