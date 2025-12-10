// https://leetcode.com/problems/3sum-closest/description/?envType=problem-list-v2&envId=two-pointers

import java.util.Arrays;

public class Problem14 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }

                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return closestSum;
    }
}