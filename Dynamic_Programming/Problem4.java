// https://leetcode.com/problems/palindromic-substrings/description/?envType=problem-list-v2&envId=dynamic-programming

public class Problem4 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int countSubstrings(String S) {
        int len = S.length(), ans = 0;
        for (int i = 0; i < len; i++) {
            int j = i - 1, k = i;
            while (k < len - 1 && S.charAt(k) == S.charAt(k + 1))
                k++;
            ans += (k - j) * (k - j + 1) / 2;
            i = k++;
            while (j >= 0 && k < len && S.charAt(k++) == S.charAt(j--))
                ans++;
        }
        return ans;
    }
}