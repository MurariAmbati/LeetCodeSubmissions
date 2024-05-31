// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome

public class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i][j + 1], dp[i + 1][j]) + 1;
                }
            }
        }
        
        return dp[n][n];
    }

}