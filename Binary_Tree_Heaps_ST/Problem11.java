// https://leetcode.com/problems/remove-stones-to-minimize-the-total/description/?envType=problem-list-v2&envId=heap-priority-queue

import java.util.Collections;
import java.util.PriorityQueue;

public class Problem11 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int minStones = 0;
        int n = piles.length;

        for (int i = 0; i < n; i++) {
            pq.add(piles[i]);
            minStones += piles[i];
        }

        while (k > 0) {
            int x = pq.poll();
            minStones -= x / 2;

            x -= x / 2;
            pq.add(x);
            k--;
        }

        return minStones;
    }
}