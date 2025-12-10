// https://leetcode.com/problems/network-delay-time/description/?envType=problem-list-v2&envId=shortest-path

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Problem12 {
    public static void main(String[] args) {

    }
}

class Tuple {
    int first, second;

    public Tuple(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Tuple>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            adj.get(time[0] - 1).add(new Tuple(time[1] - 1, time[2]));
        }

        PriorityQueue<Tuple> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.second));

        int[] visitedtime = new int[n];
        Arrays.fill(visitedtime, Integer.MAX_VALUE);
        visitedtime[k - 1] = 0;

        q.add(new Tuple(k - 1, 0));

        while (!q.isEmpty()) {
            Tuple it = q.poll();
            int node = it.first;
            int t = it.second;

            for (Tuple iter : adj.get(node)) {
                int adjnode = iter.first;
                int edgetime = iter.second;

                if (t + edgetime < visitedtime[adjnode]) {
                    visitedtime[adjnode] = t + edgetime;
                    q.add(new Tuple(adjnode, visitedtime[adjnode]));
                }
            }
        }

        int maxTime = 0;
        for (int time : visitedtime) {
            if (time == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, time);
        }

        return maxTime;
    }
}