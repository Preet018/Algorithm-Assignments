// https://leetcode.com/problems/fruits-into-baskets-iii/description/?envType=problem-list-v2&envId=segment-tree

public class Problem24 {
    public static void main(String[] args) {

    }
}

class Solution {
    private class SegmentTree {
        public int n;
        public int[] tree;

        public SegmentTree(int[] baskets) {
            n = baskets.length;
            tree = new int[4 * n];
            build(baskets, 0, 0, n - 1);
        }

        private void build(int[] arr, int node, int l, int r) {
            if (l == r) {
                tree[node] = arr[l];
                return;
            }
            int mid = (l + r) / 2;
            build(arr, 2 * node + 1, l, mid);
            build(arr, 2 * node + 2, mid + 1, r);
            tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
        }

        public int query(int fruit) {
            return query(0, 0, n - 1, fruit);
        }

        private int query(int node, int l, int r, int fruit) {
            if (tree[node] < fruit) {
                return -1;
            }

            if (l == r) {
                return l;
            }

            int mid = (l + r) / 2;

            if (tree[2 * node + 1] >= fruit) {
                return query(2 * node + 1, l, mid, fruit);
            } else {
                return query(2 * node + 2, mid + 1, r, fruit);
            }
        }

        public void update(int idx, int newVal) {
            update(0, 0, n - 1, idx, newVal);
        }

        private void update(int node, int l, int r, int idx, int newVal) {
            if (l == r) {
                tree[node] = newVal;
                return;
            }
            int mid = (l + r) / 2;
            if (idx <= mid) {
                update(2 * node + 1, l, mid, idx, newVal);
            } else {
                update(2 * node + 2, mid + 1, r, idx, newVal);
            }
            tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
        }
    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        SegmentTree seg = new SegmentTree(baskets);
        int placed = 0;

        for (int f : fruits) {
            int idx = seg.query(f);

            if (idx != -1) {
                seg.update(idx, 0);
                placed++;
            }
        }

        return fruits.length - placed;
    }
}