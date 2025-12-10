// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Problem16 {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int count = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < Math.min(n1, k); i++) {
            pq.add(new int[] { nums1[i] + nums2[0], i, 0 });
        }

        while (count < k && !pq.isEmpty()) {
            int[] pair = pq.poll();
            int i = pair[1];
            int j = pair[2];

            List<Integer> temp = new ArrayList<>();
            temp.add(nums1[i]);
            temp.add(nums2[j]);

            ans.add(temp);
            count++;

            if (j < n2 - 1) {
                pq.add(new int[] { nums1[i] + nums2[j + 1], i, j + 1 });
            }
        }

        return ans;
    }
}