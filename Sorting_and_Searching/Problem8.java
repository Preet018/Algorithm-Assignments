// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/?envType=problem-list-v2&envId=sorting

import java.util.Arrays;

public class Problem8 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0, j = 0, k = 0;
        int[] ans = new int[Math.min(n1, n2)];

        // O(n log n)
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // Merge logic from merge sort
        while (i < n1 && j < n2) {
            if (nums1[i] == nums2[j]) {
                ans[k] = nums1[i];
                i++;
                j++;
                k++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return Arrays.copyOf(ans, k);
    }
}