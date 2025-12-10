// https://leetcode.com/problems/longest-increasing-subsequence-ii/description/?envType=problem-list-v2&envId=segment-tree

import java.util.Arrays;

public class Problem17 {
    public static void main(String[] args) {

    }
}

class Solution {
    private class SegmentTree {
        int[] segTree;
        int maxIndex;

        public SegmentTree(int maxVal) {
            this.maxIndex = maxVal;
            segTree = new int[4 * (maxIndex + 2)];
            Arrays.fill(segTree, 0);
        }

        public void update(int idx, int val) {
            update(1, 0, maxIndex, idx, val);
        }

        private void update(int node, int l, int r, int idx, int val) {
            if (l == r) {
                segTree[node] = Math.max(segTree[node], val);
                return;
            }
            int mid = l + (r - l) / 2;
            if (idx <= mid) {
                update(2 * node, l, mid, idx, val);
            } else {
                update(2 * node + 1, mid + 1, r, idx, val);
            }
            segTree[node] = Math.max(segTree[2 * node], segTree[2 * node + 1]);
        }

        public int query(int ql, int qr) {
            ql = Math.max(0, ql);
            qr = Math.min(maxIndex, qr);
            if (ql > qr)
                return 0;
            return query(1, 0, maxIndex, ql, qr);
        }

        private int query(int node, int l, int r, int ql, int qr) {
            if (qr < l || r < ql) {
                return 0;
            }
            if (ql <= l && r <= qr) {
                return segTree[node];
            }
            int mid = l + (r - l) / 2;
            return Math.max(query(2 * node, l, mid, ql, qr),
                    query(2 * node + 1, mid + 1, r, ql, qr));
        }
    }

    public int lengthOfLIS(int[] nums, int k) {
        if (nums.length == 0)
            return 0;

        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        SegmentTree segTree = new SegmentTree(maxVal);

        int ans = 0;
        for (int num : nums) {
            int left = num - k;
            int right = num - 1;

            int bestPrevLIS = segTree.query(left, right);

            int currentLIS = bestPrevLIS + 1;

            segTree.update(num, currentLIS);

            ans = Math.max(ans, currentLIS);
        }
        return ans;
    }
}