// https://leetcode.com/problems/count-increasing-quadruplets/description/?envType=problem-list-v2&envId=binary-indexed-tree

class Problem23 {

}

class Solution {
    public long countQuadruplets(int[] nums) {
        long ans = 0;
        int n = nums.length;
        long[] cnt = new long[n];

        for (int i = 0; i < n; i++) {
            long prevSmall = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    prevSmall++;
                    ans += cnt[j];
                } else if (nums[i] < nums[j]) {
                    cnt[j] += prevSmall;
                }
            }
        }
        return ans;
    }

    // For testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 1, 3, 2, 4, 5 };
        System.out.println(sol.countQuadruplets(nums));
    }
}
