// https://codeforces.com/problemset/problem/1991/A

import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {

    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int ans = Integer.MIN_VALUE;
            for (int i = 0; i < n; i += 2) {
                ans = Math.max(ans, a[i]);
            }

            System.out.println(ans);
        }

        sc.close();
    }
}