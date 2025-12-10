// https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/description/?envType=problem-list-v2&envId=binary-search

public class Problem4 {
    public static void main(String[] args) {

    }
}

class Solution {
    static long findSum(int n, int index, int target) {
        long sum = 0;

        // leftsum
        int leftLen = index;
        if (leftLen < target) {
            sum += (long) leftLen * (2L * (target - 1) + (long) (leftLen - 1) * -1) / 2;
        } else {
            sum += (long) (target - 1) * target / 2;
            sum += (long) (leftLen - (target - 1));
        }

        sum += (long) target;

        // rightsum
        int rightLen = n - 1 - index;

        if (rightLen < target) {
            sum += (long) rightLen * (2L * (target - 1) + (long) (rightLen - 1) * -1) / 2;
        } else {
            sum += (long) (target - 1) * target / 2;
            sum += (long) (rightLen - (target - 1));
        }

        return sum;
    }

    public int maxValue(int n, int index, int maxSum) {
        int low = 1;
        int high = maxSum;
        int mid = (low + high) / 2;

        while (low <= high) {
            mid = (low + high) / 2;

            // leftSum + current + rightSum
            long sum = findSum(n, index, mid);

            if (maxSum < sum) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return high;
    }
}