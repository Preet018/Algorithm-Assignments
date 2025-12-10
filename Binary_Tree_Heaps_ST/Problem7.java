// https://leetcode.com/problems/longest-univalue-path/description/?envType=problem-list-v2&envId=binary-tree

public class Problem7 {
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
    static int ans;

    static int findLUP(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l_LUP = findLUP(root.left);
        int r_LUP = findLUP(root.right);

        int maxl = 0;
        int maxr = 0;

        if (root.left != null && root.left.val == root.val) {
            maxl = l_LUP + 1;
        }

        if (root.right != null && root.right.val == root.val) {
            maxr = r_LUP + 1;
        }

        ans = Math.max(ans, maxl + maxr);

        return Math.max(maxl, maxr);
    }

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        findLUP(root);

        return ans;
    }
}