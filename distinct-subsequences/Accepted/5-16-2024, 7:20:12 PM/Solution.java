// https://leetcode.com/problems/distinct-subsequences

public class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // Initialize dp array
        int[][] dp = new int[m + 1][n + 1];
        
        // Base case: Empty string t can be formed from any non-empty string s
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        
        // Fill up the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // Characters match, two choices: include or exclude current character
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // Characters don't match, exclude current character
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        // Return the number of distinct subsequences of s which equals t
        return dp[m][n];
    }
}