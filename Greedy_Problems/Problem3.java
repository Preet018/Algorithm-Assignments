// https://codeforces.com/problemset/problem/2002/B

import java.util.Scanner;

public class Problem3 {
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
            int[] b = new int[n];

            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            for (int i = 0; i < n; i++)
                b[i] = sc.nextInt();

            boolean same = true;
            boolean rev = true;

            for (int i = 0; i < n; i++) {
                if (a[i] != b[i])
                    same = false;
                if (a[i] != b[n - 1 - i])
                    rev = false;
                if (!same && !rev)
                    break;
            }

            if (same || rev) {
                System.out.println("Bob");
            } else {
                System.out.println("Alice");
            }
        }

        sc.close();
    }
}
