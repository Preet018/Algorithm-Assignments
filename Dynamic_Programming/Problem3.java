// https://leetcode.com/problems/maximum-length-of-pair-chain/description/?envType=problem-list-v2&envId=dynamic-programming

import java.util.Arrays;

public class Problem3 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));
        int curr = Integer.MIN_VALUE;
        int len = 0;
        for (int arr[] : pairs) {
            if (curr < arr[0]) {
                len++;
                curr = arr[1];
            }
        }
        return len;
    }
}