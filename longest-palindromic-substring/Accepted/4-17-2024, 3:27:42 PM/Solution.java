// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }

        // Create a boolean table to store dp[i][j] - Whether the substring s.substring(i, j + 1) is a palindrome
        boolean[][] dp = new boolean[n][n];

        // Base cases: Single characters are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Length 2 substrings
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLen = 2;
                start = i;
            }
        }

        // Length 3+ substrings
        for (int k = 3; k <= n; k++) {
            for (int i = 0; i <= n - k; i++) {
                int j = i + k - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    maxLen = k;
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}
