// https://leetcode.com/problems/total-cost-to-hire-k-workers/description/?envType=problem-list-v2&envId=heap-priority-queue

import java.util.PriorityQueue;

public class Problem10 {
    public static void main(String[] args) {

    }
}

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long minSum = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (a[0] != b[0]) ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        for (int i = 0; i < candidates; i++) {
            pq.add(new int[] { costs[i], i });
        }

        int f_end = pq.size() - 1;
        int l_end = Math.max(f_end + 1, n - candidates);

        for (int j = l_end; j < n; j++) {
            pq.add(new int[] { costs[j], j });
        }

        while (k > 0) {
            int[] temp = pq.poll();

            minSum += temp[0];

            if (f_end < l_end - 1) {
                if (temp[1] <= f_end) {
                    f_end++;
                    pq.add(new int[] { costs[f_end], f_end });
                } else {
                    l_end--;
                    pq.add(new int[] { costs[l_end], l_end });
                }
            }

            k--;
        }

        return minSum;
    }
}