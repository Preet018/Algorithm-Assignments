// https://leetcode.com/problems/median-of-two-sorted-arrays/description/

public class Problem15 {
    public static void main(String[] args) {

    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int k = (n1 + n2) / 2;

        int low = Math.max(0, k - n2);
        int high = Math.min(n1, k);

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = k - mid1;

            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;

            if (mid1 < n1) {
                r1 = nums1[mid1];
            }
            if (mid2 < n2) {
                r2 = nums2[mid2];
            }

            if (mid1 > 0) {
                l1 = nums1[mid1 - 1];
            }
            if (mid2 > 0) {
                l2 = nums2[mid2 - 1];
            }

            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0) {
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.min(r1, r2);
                }
            }

            if (l2 > r1) {
                low = mid1 + 1;
            } else if (l1 > r2) {
                high = mid1 - 1;
            }
        }

        return 0;
    }
}