// https://leetcode.com/problems/maximum-sum-queries/description/?envType=problem-list-v2&envId=segment-tree

import java.util.*;
import java.util.function.Function;

public class Problem25 {
    public static void main(String[] args) {

    }
}

class Solution {
    private class SegmentTree {
        int m;
        int[] seg;

        public SegmentTree(int m) {
            this.m = m;
            this.seg = new int[4 * m];
            Arrays.fill(seg, -1);
        }

        public void update(int idx, int val) {
            update(1, 0, m - 1, idx, val);
        }

        private void update(int node, int l, int r, int idx, int val) {
            if (l == r) {
                seg[node] = Math.max(seg[node], val);
                return;
            }
            int mid = l + (r - l) / 2;
            if (idx <= mid) {
                update(2 * node, l, mid, idx, val);
            } else {
                update(2 * node + 1, mid + 1, r, idx, val);
            }
            seg[node] = Math.max(seg[2 * node], seg[2 * node + 1]);
        }

        public int query(int ql, int qr) {
            if (ql > qr)
                return -1;
            return query(1, 0, m - 1, ql, qr);
        }

        private int query(int node, int l, int r, int ql, int qr) {
            if (qr < l || r < ql) {
                return -1;
            }
            if (ql <= l && r <= qr) {
                return seg[node];
            }
            int mid = l + (r - l) / 2;
            return Math.max(query(2 * node, l, mid, ql, qr),
                    query(2 * node + 1, mid + 1, r, ql, qr));
        }
    }

    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        int q = queries.length;

        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = nums1[i];
            points[i][1] = nums2[i];
        }
        Arrays.sort(points, (a, b) -> b[0] - a[0]);

        int[][] qs = new int[q][3];
        for (int i = 0; i < q; i++) {
            qs[i][0] = queries[i][0];
            qs[i][1] = queries[i][1];
            qs[i][2] = i;
        }
        Arrays.sort(qs, (a, b) -> b[0] - a[0]);

        Set<Integer> uniqueCoordsSet = new TreeSet<>();
        for (int[] p : points)
            uniqueCoordsSet.add(p[1]);
        for (int[] qq : qs)
            uniqueCoordsSet.add(qq[1]);

        int[] coords = uniqueCoordsSet.stream().mapToInt(i -> i).toArray();
        int m = coords.length;

        Function<Integer, Integer> getIndex = (val) -> {
            int res = Arrays.binarySearch(coords, val);
            if (res >= 0) {
                return res;
            } else {
                return -res - 1;
            }
        };

        SegmentTree segTree = new SegmentTree(m);
        int[] ans = new int[q];
        int pointIdx = 0;

        for (int[] qq : qs) {
            int x = qq[0], y = qq[1], qi = qq[2];

            while (pointIdx < n && points[pointIdx][0] >= x) {
                int py = points[pointIdx][1];
                int compY = getIndex.apply(py);
                int val = points[pointIdx][0] + py;

                segTree.update(compY, val);
                pointIdx++;
            }

            int compY = getIndex.apply(y);
            ans[qi] = segTree.query(compY, m - 1);
        }

        return ans;
    }
}