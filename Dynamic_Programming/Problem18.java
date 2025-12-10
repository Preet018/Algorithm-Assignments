// https://leetcode.com/problems/minimum-time-to-remove-all-cars-containing-illegal-goods/description/?envType=problem-list-v2&envId=dynamic-programming

public class Problem18 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minimumTime(String s) {
        int res = s.length();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            start = Math.min(start + (s.charAt(i) - '0') * 2, i + 1);
            res = Math.min(res, start + s.length() - i - 1);
        }
        return res;
    }
}