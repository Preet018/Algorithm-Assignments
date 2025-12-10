// https://leetcode.com/problems/search-a-2d-matrix/description/?envType=problem-list-v2&envId=binary-search

class Solution {
    static boolean binarysearch2D(int[][] matrix, int target, int low, int high) {
        int n = matrix[0].length;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (target == matrix[mid / n][mid % n]) {
                return true;
            } else if (target < matrix[mid / n][mid % n]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        return binarysearch2D(matrix, target, 0, m * n - 1);
    }
}