// https://leetcode.com/problems/minimum-time-difference/description/?envType=problem-list-v2&envId=sorting

import java.util.Arrays;
import java.util.List;

public class Problem7 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int minDiff = Integer.MAX_VALUE;
        int[] mins = new int[n];

        for (int i = 0; i < n; i++) {
            String str = timePoints.get(i);

            int hr = Integer.parseInt(str.substring(0, 2));
            int min = Integer.parseInt(str.substring(3));

            mins[i] = hr * 60 + min;
        }

        Arrays.sort(mins);

        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, mins[i] - mins[i - 1]);
        }

        minDiff = Math.min(minDiff, 1440 - (mins[n - 1] - mins[0]));

        return minDiff;
    }
}