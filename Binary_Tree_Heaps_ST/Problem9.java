// https://leetcode.com/problems/reveal-cards-in-increasing-order/solutions/5001130/beat-100-using-deque/?envType=problem-list-v2&envId=queue

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Problem9 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[n];

        Arrays.sort(deck);

        dq.addFirst(deck[n - 1]);

        // applying reveal logic in reverse
        for (int i = n - 2; i >= 0; i--) {
            dq.addFirst(dq.removeLast());
            dq.addFirst(deck[i]);
        }

        for (int i = 0; i < n; i++) {
            ans[i] = dq.removeFirst();
        }

        return ans;
    }
}