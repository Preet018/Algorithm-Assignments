// https://leetcode.com/problems/house-robber-iii/description/?envType=problem-list-v2&envId=depth-first-search

public class Problem3 {
    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    int[] dfs(TreeNode n) {
        if (n == null)
            return new int[] { 0, 0 };
        int[] l = dfs(n.left);
        int[] r = dfs(n.right);

        int[] res = new int[2];
        res[0] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        res[1] = n.val + l[0] + r[0];
        return res;
    }
}