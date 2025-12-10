// https://codeforces.com/problemset/problem/2003/D1

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem9 {
    public static void main(String[] args) {

    }
}

class Main {

    // same as the lambda sum1to in C++
    static long sum1to(long x) {
        if (x <= 0)
            return 0L;
        return x * (x + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {

            int n = sc.nextInt();
            long m = sc.nextLong();

            ArrayList<Integer> secondMissing = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {

                int li = sc.nextInt();
                // +2 like C++ code, because we’re checking until 2nd missing appears
                boolean[] present = new boolean[li + 2];

                for (int j = 0; j < li; j++) {
                    long a = sc.nextLong();
                    if (a >= 0 && a < present.length) {
                        present[(int) a] = true;
                    }
                }

                int missingCnt = 0;
                int sm = 0; // second missing value

                for (int v = 0; v < present.length; v++) {
                    if (!present[v])
                        missingCnt++;
                    if (missingCnt == 2) {
                        sm = v;
                        break;
                    }
                }

                secondMissing.add(sm);
            }

            int lim = 0;
            if (!secondMissing.isEmpty()) {
                lim = Collections.max(secondMissing);
            }

            long stop = Math.min(m, lim);
            long res = (stop + 1L) * lim;

            if (m > lim) {
                res += (sum1to(m) - sum1to(lim));
            }

            System.out.println(res);
        }

        sc.close();
    }
}
