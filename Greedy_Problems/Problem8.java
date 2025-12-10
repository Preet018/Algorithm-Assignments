// https://codeforces.com/contest/1526/problem/C2

import java.util.Scanner;
import java.util.PriorityQueue;

public class Problem8 {
    public static void main(String[] args) {

    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // Min-heap in Java (same as priority_queue with greater<> in C++)
        PriorityQueue<Long> pq = new PriorityQueue<>();

        long health = 0;

        for (int i = 0; i < n; i++) {
            long x = sc.nextLong();

            health += x;
            pq.add(x);

            if (health < 0) {
                health -= pq.peek(); // remove the smallest element we added
                pq.poll();
            }
        }

        System.out.println(pq.size());

        sc.close();
    }
}
