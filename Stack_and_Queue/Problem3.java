// https://leetcode.com/problems/count-of-smaller-numbers-after-self/?envType=problem-list-v2&envId=binary-search

import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static void main(String[] args) {

    }
}

class Solution {
    static void merge(int[][] arr, int low, int high, int[] ans) {
        int mid = (low + high) / 2;
        int i = low, j = mid + 1, k = 0;
        int[][] temp = new int[high - low + 1][2];

        while (i <= mid && j <= high) {
            if (arr[i][0] > arr[j][0]) {
                ans[arr[i][1]] += high - j + 1;
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        while (j <= high) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        k = 0;
        i = low;

        while (i <= high) {
            arr[i] = temp[k];
            i++;
            k++;
        }
    }

    static void mergesort(int[][] arr, int low, int high, int[] ans) {
        int mid = (low + high) / 2;

        if (low >= high) {
            return;
        }

        mergesort(arr, low, mid, ans);
        mergesort(arr, mid + 1, high, ans);
        merge(arr, low, high, ans);
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        mergesort(arr, 0, n - 1, ans);

        return Arrays.stream(ans).boxed().toList();
    }
}