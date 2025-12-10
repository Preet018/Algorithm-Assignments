// https://leetcode.com/problems/find-building-where-alice-and-bob-can-meet/description/?envType=problem-list-v2&envId=segment-tree

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Problem18 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length, q = queries.length;
        int[] result = new int[q];

        Arrays.fill(result, -1);

        List<List<int[]>> deferred = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            deferred.add(new ArrayList<>());
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < q; ++i) {
            int a = queries[i][0], b = queries[i][1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            if (a == b || heights[a] < heights[b])
                result[i] = b;
            else
                deferred.get(b).add(new int[] { heights[a], i });
        }

        for (int i = 0; i < n; ++i) {
            for (int[] query : deferred.get(i))
                pq.add(query);
            while (!pq.isEmpty() && pq.peek()[0] < heights[i]) {
                result[pq.poll()[1]] = i;
            }
        }

        return result;
    }
}