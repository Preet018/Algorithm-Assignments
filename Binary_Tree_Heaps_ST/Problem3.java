// https://leetcode.com/problems/diameter-of-binary-tree/description/?envType=problem-list-v2&envId=binary-tree

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
    static int[] MaxDepthAndDia(TreeNode root) {
        int[] ans = new int[] { 0, 0 };

        if (root == null) {
            return ans;
        }

        int[] l_DaD = MaxDepthAndDia(root.left);
        int[] r_DaD = MaxDepthAndDia(root.right);

        // Calculating height of this node
        ans[0] = Math.max(l_DaD[0], r_DaD[0]) + 1;

        // Updating diameter
        ans[1] = Math.max(ans[1], l_DaD[0] + r_DaD[0]);
        ans[1] = Math.max(ans[1], Math.max(l_DaD[1], r_DaD[1]));

        return ans;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = MaxDepthAndDia(root);

        return result[1];
    }
}