// https://leetcode.com/problems/count-of-range-sum/description/?envType=problem-list-v2&envId=segment-tree

public class Problem16 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        return mergeSort(prefix, 0, n + 1, lower, upper);
    }

    private int mergeSort(long[] prefix, int left, int right, int lower, int upper) {
        if (right - left <= 1) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        int count = mergeSort(prefix, left, mid, lower, upper) +
                mergeSort(prefix, mid, right, lower, upper);

        int j = mid, k = mid;

        for (int i = left; i < mid; i++) {
            while (k < right && prefix[k] - prefix[i] < lower) {
                k++;
            }
            while (j < right && prefix[j] - prefix[i] <= upper) {
                j++;
            }
            count += j - k;
        }

        long[] temp = new long[right - left];
        int i = left, p = mid, t = 0;

        while (i < mid && p < right) {
            if (prefix[i] <= prefix[p]) {
                temp[t++] = prefix[i++];
            } else {
                temp[t++] = prefix[p++];
            }
        }
        while (i < mid) {
            temp[t++] = prefix[i++];
        }
        while (p < right) {
            temp[t++] = prefix[p++];
        }

        for (t = 0; t < temp.length; t++) {
            prefix[left + t] = temp[t];
        }

        return count;
    }
}