// https://leetcode.com/problems/reverse-pairs/description/

public class Problem10 {
    public static void main(String[] args) {

    }
}

class Solution {
    public static void merge(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        int i = low, j = mid + 1, k = 0;
        int[] temp = new int[high - low + 1];

        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }
        while (j <= high) {
            temp[k] = nums[j];
            j++;
            k++;
        }

        k = 0;
        i = low;

        while (i <= high) {
            nums[i] = temp[k];
            k++;
            i++;
        }
    }

    public static int mergesort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        int ans = 0;

        if (low == high) {
            return 0;
        }

        ans += mergesort(nums, low, mid) + mergesort(nums, mid + 1, high);
        ans += countPairs(nums, low, high);
        merge(nums, low, high);

        return ans;
    }

    public static int countPairs(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        int i = low;
        int j = mid + 1;
        int ans = 0;

        while (i <= mid && j <= high) {
            if ((long) nums[i] > (long) 2 * nums[j]) {
                ans += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }

        return ans;
    }

    public int reversePairs(int[] nums) {
        return mergesort(nums, 0, nums.length - 1);
    }
}