// https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/practice-problems/algorithm/monk-and-champions-league/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Problem13 {
    public static void main(String[] args) {

    }
}

class TestClass {

    public static int maxpounds(List<Integer> rows, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(rows);

        int mxp = 0;
        while (n-- > 0) {
            int a = pq.poll();
            mxp += a;
            a = a - 1;
            pq.add(a);
        }
        return mxp;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = br.readLine().split(" ");
        int m = Integer.parseInt(parts[0]);
        int n = Integer.parseInt(parts[1]);

        String[] arrStr = br.readLine().split(" ");
        List<Integer> rows = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            rows.add(Integer.parseInt(arrStr[i]));
        }

        System.out.println(maxpounds(rows, n));
    }
}
