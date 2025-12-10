// https://leetcode.com/problems/single-element-in-a-sorted-array/?envType=problem-list-v2&envId=binary-search

public class Problem2 {
    public static void main(String[] args) {

    }
}

class Solution {
    public static int binarysearchSE(int[] arr, int low, int high) {
        int mid = (low + high) / 2;

        if (low == high) {
            return arr[low];
        }

        if (arr[mid - 1] == arr[mid]) {
            if ((mid - low + 1) % 2 == 0) {
                return binarysearchSE(arr, mid + 1, high);
            } else {
                return binarysearchSE(arr, low, mid);
            }
        } else if (arr[mid] == arr[mid + 1]) {
            if ((high - mid + 1) % 2 == 0) {
                return binarysearchSE(arr, low, mid - 1);
            } else {
                return binarysearchSE(arr, mid, high);
            }
        } else {
            return arr[mid];
        }
    }

    public int singleNonDuplicate(int[] nums) {
        return binarysearchSE(nums, 0, nums.length - 1);
    }
}