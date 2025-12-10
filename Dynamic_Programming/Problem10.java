// https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/description/?envType=problem-list-v2&envId=dynamic-programming

public class Problem10 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int twoEggDrop(int n) {
        int ans = 1, times = 1;

        while (ans < n) {
            times++;
            ans += times;
        }

        return times;
    }
}