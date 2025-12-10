// https://leetcode.com/problems/first-missing-positive/description/?envType=problem-list-v2&envId=hash-table

public class Problem19 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int orgIdx = nums[i] - 1;

            while (0 <= orgIdx && orgIdx < n && nums[i] != i + 1 && nums[i] != nums[orgIdx]) {
                int temp = nums[i];
                nums[i] = nums[orgIdx];
                nums[orgIdx] = temp;

                orgIdx = nums[i] - 1;
            }
        }

        int i = 0;
        while (i < n && nums[i] == i + 1) {
            i++;
        }

        return i + 1;
    }
}