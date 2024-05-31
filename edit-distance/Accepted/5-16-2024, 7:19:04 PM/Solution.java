// https://leetcode.com/problems/edit-distance

public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // Create a 2D array to store the minimum number of operations required
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize the base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // Operations required to convert word1[0...i-1] to an empty string
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // Operations required to convert an empty string to word2[0...j-1]
        }
        
        // Fill the dp array iteratively
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                }
            }
        }
        
        // Return the minimum number of operations required to convert word1 to word2
        return dp[m][n];
    }
}