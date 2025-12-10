// https://leetcode.com/problems/3sum/description/?envType=problem-list-v2&envId=two-pointers

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem12 {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            if (nums[i] > 0) {
                break;
            }

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    list.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    while (j < k && nums[j - 1] == nums[j]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }

        }

        return list;
    }
}