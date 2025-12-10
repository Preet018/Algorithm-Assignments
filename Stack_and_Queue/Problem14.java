// https://leetcode.com/problems/count-subarrays-with-fixed-bounds/description/?envType=problem-list-v2&envId=queue

public class Problem14 {
    public static void main(String[] args) {

    }
}

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int start = -1;
        int mn = -1;
        int mx = -1;
        long res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                start = i;
                continue;
            }

            if (nums[i] == minK) {
                mn = i;
            }

            if (nums[i] == maxK) {
                mx = i;
            }

            int startIndex = Math.min(mn, mx);
            if (startIndex < start) {
                continue;
            }

            res += (startIndex - start);
        }

        return res;
    }
}
