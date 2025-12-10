// https://leetcode.com/problems/count-number-of-teams/description/?envType=problem-list-v2&envId=binary-indexed-tree

public class Problem19 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;

        for (int j = 0; j < n; j++) {
            int leftSmaller = 0, leftLarger = 0;
            int rightSmaller = 0, rightLarger = 0;

            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    leftSmaller++;
                }
                if (rating[i] > rating[j]) {
                    leftLarger++;
                }
            }

            for (int k = j + 1; k < n; k++) {
                if (rating[k] > rating[j]) {
                    rightLarger++;
                }
                if (rating[k] < rating[j]) {
                    rightSmaller++;
                }
            }

            count += leftSmaller * rightLarger;
            count += leftLarger * rightSmaller;
        }

        return count;
    }
}