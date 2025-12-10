// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/?envType=problem-list-v2&envId=binary-tree

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

public class Problem4 {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        int level = 1;
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> nodes = new ArrayList<>();
            int nodesAtL = q.size();

            for (int i = 0; i < nodesAtL; i++) {
                TreeNode node = q.poll();

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }

                if (level % 2 != 0) {
                    nodes.add(node.val);
                } else {
                    nodes.addFirst(node.val);
                }
            }
            level++;

            ans.add(nodes);
        }

        return ans;
    }
}