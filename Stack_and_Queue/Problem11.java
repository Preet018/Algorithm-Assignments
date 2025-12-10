// https://leetcode.com/problems/beautiful-towers-ii/description/?envType=problem-list-v2&envId=stack

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Problem11 {
    public static void main(String[] args) {

    }
}

class Solution {
    static List<Integer> findleft(List<Integer> maxHeights) {
        List<Integer> left = new ArrayList<>();
        int n = maxHeights.size();
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && maxHeights.get(stk.peek()) >= maxHeights.get(i)) {
                stk.pop();
            }

            if (stk.isEmpty()) {
                left.add(-1);
            } else {
                left.add(stk.peek());
            }

            stk.push(i);
        }

        return left;
    }

    static List<Long> findLSum(List<Integer> maxHeights, List<Integer> left) {
        int n = maxHeights.size();
        List<Long> leftSum = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (left.get(i) == -1) {
                leftSum.add((long) maxHeights.get(i) * (i - left.get(i)));
            } else {
                leftSum.add(leftSum.get(left.get(i)) + (long) maxHeights.get(i) * (i - left.get(i)));
            }
        }

        return leftSum;
    }

    static List<Integer> findright(List<Integer> maxHeights) {
        List<Integer> right = new ArrayList<>(Collections.nCopies(maxHeights.size(), 0));
        int n = maxHeights.size();
        Stack<Integer> stk = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && maxHeights.get(stk.peek()) >= maxHeights.get(i)) {
                stk.pop();
            }

            if (stk.isEmpty()) {
                right.set(i, n);
            } else {
                right.set(i, stk.peek());
            }

            stk.push(i);
        }

        return right;
    }

    static List<Long> findRSum(List<Integer> maxHeights, List<Integer> right) {
        int n = maxHeights.size();
        List<Long> rightSum = new ArrayList<>(Collections.nCopies(n, 0L));

        for (int i = n - 1; i >= 0; i--) {
            if (right.get(i) == n) {
                rightSum.set(i, (long) maxHeights.get(i) * (right.get(i) - i));
            } else {
                rightSum.set(i, (long) maxHeights.get(i) * (right.get(i) - i) + rightSum.get(right.get(i)));
            }
        }

        return rightSum;
    }

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long maxHeight = 0;

        List<Integer> left = findleft(maxHeights);
        List<Long> leftSum = findLSum(maxHeights, left);

        List<Integer> right = findright(maxHeights);
        List<Long> rightSum = findRSum(maxHeights, right);

        for (int i = 0; i < n; i++) {
            long temp = leftSum.get(i) + rightSum.get(i) - maxHeights.get(i);
            maxHeight = Math.max(maxHeight, temp);
        }

        return maxHeight;
    }
}