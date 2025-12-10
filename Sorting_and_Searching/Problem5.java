// https://leetcode.com/problems/nth-magical-number/description/

public class Problem5 {
    public static void main(String[] args) {

    }
}

class Solution {
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    public int nthMagicalNumber(int n, int a, int b) {
        long low = Math.min(a, b);
        long high = n * low;
        long mid = (low + high) / 2;

        long lcm = lcm(a, b);
        long m = (long) 1e9 + 7;

        while (low < high) {
            mid = (low + high) / 2;
            long factors = mid / a + mid / b - mid / lcm;

            if (factors < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return (int) (low % m);
    }
}