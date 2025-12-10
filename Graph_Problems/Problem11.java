// https://leetcode.com/problems/maximum-width-of-binary-tree/description/?envType=problem-list-v2&envId=breadth-first-search

import java.util.LinkedList;
import java.util.Queue;

public class Problem11 {
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

class Pair {
    TreeNode node;
    int num;

    public Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minOfThatLevel = queue.peek().num;
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair polled = queue.poll();
                int cur_id = polled.num - minOfThatLevel;

                if (i == 0)
                    first = cur_id;
                if (i == size - 1)
                    last = cur_id;

                if (polled.node.left != null)
                    queue.add(new Pair(polled.node.left, cur_id * 2 + 1));
                if (polled.node.right != null)
                    queue.add(new Pair(polled.node.right, cur_id * 2 + 2));
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        return maxWidth;
    }
}