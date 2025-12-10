// https://leetcode.com/problems/4sum/description/?envType=problem-list-v2&envId=two-pointers

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem13 {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {
                int k = j + 1;
                int l = nums.length - 1;

                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }

                // implementing 2 sum for each pair so that overall sum is target
                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (target == sum) {
                        ans.add(List.of(nums[i], nums[j], nums[k], nums[l]));

                        k++;
                        l--;
                        while (k < l && nums[k - 1] == nums[k]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    } else if (target > sum) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return ans;
    }
}