// https://codeforces.com/problemset/problem/2013/B

import java.util.Scanner;

public class Problem7 {
    public static void main(String[] args) {

    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n + 1];

            long sum = 0;
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextLong();
                sum += a[i];
            }

            long ans = sum - (2 * a[n - 1]);
            System.out.println(ans);
        }

        sc.close();
    }
}
