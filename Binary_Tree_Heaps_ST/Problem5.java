// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/?envType=problem-list-v2&envId=binary-tree

import java.util.HashMap;

public class Problem5 {
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        if (n == 0) {
            return null;
        }

        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = new TreeNode(preorder[0], null, null);

        for (int i = 1; i < n; i++) {
            TreeNode node = root;
            int currIdx = map.get(preorder[i]);

            while (node != null) {
                if (currIdx < map.get(node.val)) {
                    if (node.left != null) {
                        node = node.left;
                    } else {
                        node.left = new TreeNode(preorder[i], null, null);
                        node = null;
                    }
                } else {
                    if (node.right != null) {
                        node = node.right;
                    } else {
                        node.right = new TreeNode(preorder[i], null, null);
                        node = null;
                    }
                }
            }
        }

        return root;
    }
}