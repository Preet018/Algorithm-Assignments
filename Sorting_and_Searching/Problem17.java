// https://leetcode.com/problems/count-number-of-bad-pairs/description/?envType=problem-list-v2&envId=hash-table

import java.util.HashMap;

public class Problem17 {
    public static void main(String[] args) {

    }
}

class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        long notBP = 0;
        long totalPairs = (long) n * (n - 1) / 2;

        for (int i = 0; i < n; i++) {
            int key = nums[i] - i;

            notBP += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return totalPairs - notBP;
    }
}