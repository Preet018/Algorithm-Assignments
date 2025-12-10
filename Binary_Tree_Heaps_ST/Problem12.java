// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/

import java.util.PriorityQueue;

public class Problem12 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        for (int r = 0; r < n; r++) {
            minHeap.offer(new int[] { matrix[r][0], r, 0 });
        }

        int val = -1;
        for (int i = 0; i < k; i++) {
            int[] current = minHeap.poll();
            val = current[0];
            int row = current[1];
            int col = current[2];

            if (col + 1 < n) {
                minHeap.offer(new int[] { matrix[row][col + 1], row, col + 1 });
            }
        }
        return val;
    }
}