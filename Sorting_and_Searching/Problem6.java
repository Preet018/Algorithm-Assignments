// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/

public class Problem6 {
    public static void main(String[] args) {

    }
}

class Solution {
    static boolean canbemade(int[] bloomDay, int days, int m, int k) {
        int n = bloomDay.length;
        int flowers = 0;
        int bouquets = 0;

        // for mid checking if that is possible ans
        for (int i = 0; i < n; i++) {
            if (bloomDay[i] <= days) {
                flowers++;
            } else {
                flowers = 0;
            }
            if (flowers == k) {
                bouquets++;
                flowers = 0;
            }
            if (bouquets == m) {
                return true;
            }
        }

        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // find min and max of array (solution will fall in that range)
        for (int i = 0; i < n; i++) {
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }
        int mid = (low + high) / 2;

        // applying BS in that solution space
        while (low < high) {
            mid = (low + high) / 2;

            if (canbemade(bloomDay, mid, m, k)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        if (canbemade(bloomDay, low, m, k)) {
            return low;
        } else {
            return -1;
        }

    }
}