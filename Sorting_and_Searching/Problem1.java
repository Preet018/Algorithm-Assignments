// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/?envType=problem-list-v2&envId=binary-search

public class Problem1 {
    public static void main(String[] args) {

    }
}

class Solution {
    public static int binarySearch(int[] arr, int target, int low, int high) {
        int mid = (low + high) / 2;

        if (low == high) {
            return low;
        }

        if (target <= arr[mid]) {
            return binarySearch(arr, target, low, mid);
        } else {
            return binarySearch(arr, target, mid + 1, high);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];

        if (nums.length == 0) {
            arr[0] = -1;
            arr[1] = -1;
            return arr;
        }

        arr[0] = binarySearch(nums, target, 0, nums.length - 1);

        if (nums[arr[0]] != target) {
            arr[0] = -1;
            arr[1] = -1;

            return arr;
        }

        arr[1] = binarySearch(nums, target + 1, 0, nums.length - 1);

        if (nums[arr[1]] != target) {
            arr[1]--;
        }

        return arr;
    }
}