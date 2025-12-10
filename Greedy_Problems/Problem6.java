// https://leetcode.com/problems/lexicographically-smallest-string-after-substring-operation/

public class Problem6 {
    public static void main(String[] args) {

    }
}

class Solution {
    public String smallestString(String s) {
        int i = 0, n = s.length();

        // Find the first non-'a' character
        while (i < n && s.charAt(i) == 'a') {
            i++;
        }

        if (i == n) {
            // If the string is all 'a's, change the last character to 'z'
            char[] chars = s.toCharArray();
            chars[n - 1] = 'z';
            return String.valueOf(chars);
        }

        int j = i;
        char[] chars = s.toCharArray();

        // Decrement the characters until the first non-'a' character
        while (j < n && chars[j] != 'a') {
            chars[j] -= 1;
            j++;
        }

        return String.valueOf(chars);
    }
}