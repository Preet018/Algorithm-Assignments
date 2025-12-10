// https://leetcode.com/problems/continuous-subarray-sum/description/

import java.util.HashMap;

public class Problem20 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;

        if (n < 2) {
            return false;
        }

        HashMap<Integer, Integer> prefixRem = new HashMap<>();
        int sum = 0;

        prefixRem.put(0, -1);

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            // check if same rem is exist and if length of subarray is >2
            if (prefixRem.containsKey(sum % k) && (i - prefixRem.get(sum % k)) > 1) {
                return true;
            }

            if (!prefixRem.containsKey(sum % k)) {
                prefixRem.put(sum % k, i);
            }
        }

        return false;
    }
}