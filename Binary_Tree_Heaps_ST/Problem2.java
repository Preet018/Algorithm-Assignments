// https://leetcode.com/problems/balanced-binary-tree/description/?envType=problem-list-v2&envId=binary-tree

public class Problem2 {
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
    static int isBOrmaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = isBOrmaxDepth(root.left);
        int rh = isBOrmaxDepth(root.right);

        if (lh == -1 || rh == -1) {
            return -1;
        } else if (Math.abs(rh - lh) > 1) {
            return -1;
        }

        return 1 + Math.max(lh, rh);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int ans = isBOrmaxDepth(root);

        if (ans == -1) {
            return false;
        }

        return true;
    }
}