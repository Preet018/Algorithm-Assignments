// https://leetcode.com/problems/binary-tree-cameras/description/?envType=problem-list-v2&envId=binary-tree

import java.util.HashSet;
import java.util.Set;

public class Problem8 {
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
    static int cameras;
    static Set<TreeNode> covered;

    static void addCam(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }

        addCam(node.left, node);
        addCam(node.right, node);

        if ((parent == null && !covered.contains(node)) || !covered.contains(node.left)
                || !covered.contains(node.right)) {
            cameras++;
            covered.add(parent);
            covered.add(node);
            covered.add(node.left);
            covered.add(node.right);
        }
    }

    public int minCameraCover(TreeNode root) {
        covered = new HashSet<>();
        cameras = 0;

        covered.add(null);
        addCam(root, null);

        return cameras;
    }
}