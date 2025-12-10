// https://leetcode.com/problems/find-all-duplicates-in-an-array/description/?envType=problem-list-v2&envId=hash-table

import java.util.ArrayList;
import java.util.List;

public class Problem18 {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int orgIdx = nums[i] - 1;

            while (nums[i] != i + 1 && nums[i] != nums[orgIdx]) {
                int temp = nums[i];
                nums[i] = nums[orgIdx];
                nums[orgIdx] = temp;

                orgIdx = nums[i] - 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                ans.add(nums[i]);
            }
        }

        return ans;
    }
}