// https://leetcode.com/problems/wildcard-matching

class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // Initialize a 2D boolean DP table to store results
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case: empty string matches empty pattern
        dp[0][0] = true;

        // Handle patterns with leading '*' (can match empty string)
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1]; // Inherit from the previous '*' match
            }
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char ch1 = s.charAt(i - 1);
                char ch2 = p.charAt(j - 1);

                // If characters match or pattern is '?' (match any single char)
                if (ch1 == ch2 || ch2 == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (ch2 == '*') {
                    // '*' can match multiple characters or zero characters
                    // Try skipping the character in the string (dp[i][j - 1])
                    // Or try matching the character and continuing (dp[i - 1][j])
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j]; 
                }
            }
        }

        // Return the bottom right corner of the DP table for the final result
        return dp[m][n];
    }
}
