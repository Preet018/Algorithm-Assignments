// https://leetcode.com/problems/number-of-pairs-satisfying-inequality/description/?envType=problem-list-v2&envId=binary-indexed-tree

public class Problem20 {

}

class Solution {
    public long mergeSort(int[] arr, int left, int right, int diff) {
        if (left >= right)
            return 0;
        long count = 0;
        int mid = left + (right - left) / 2;
        count += mergeSort(arr, left, mid, diff);
        count += mergeSort(arr, mid + 1, right, diff);
        count += countPairs(arr, left, mid, right, diff);
        merge(arr, left, mid, right);
        return count;
    }

    long countPairs(int[] arr, int left, int mid, int right, int diff) {
        long count = 0;
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {

            while (j <= right && arr[i] > arr[j] + diff) {
                j++;
            }
            count += (right - j + 1);
        }
        return count;
    }

    void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[right - left + 1];

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid)
            temp[k++] = arr[i++];
        while (j <= right)
            temp[k++] = arr[j++];
        for (int t = 0; t < temp.length; t++) {
            arr[t + left] = temp[t];
        }

    }

    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums1[i] - nums2[i];
        }

        long count = mergeSort(arr, 0, n - 1, diff);
        return count;

    }
}