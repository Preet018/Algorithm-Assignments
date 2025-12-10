// https://leetcode.com/problems/merge-intervals/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem11 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] temp = intervals[0];

        for (int i = 1; i < n; i++) {
            // start of curr is smaller than end of prev then overlap
            if (intervals[i][0] <= temp[1]) {
                temp[1] = Math.max(temp[1], intervals[i][1]);
            } else {
                ans.add(temp);
                temp = intervals[i];
            }
        }

        ans.add(temp);

        return ans.toArray(new int[ans.size()][]);
    }
}