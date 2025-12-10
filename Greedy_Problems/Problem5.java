// https://codeforces.com/problemset/problem/1909/B

import java.util.Arrays;
import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {

    }
}

class Main {

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] arr = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }

            Arrays.sort(arr);

            long d = 0;
            for (int i = 1; i < n; i++) {
                d = gcd(d, arr[i] - arr[0]);
            }

            System.out.println(2L * d);
        }

        sc.close();
    }
}
