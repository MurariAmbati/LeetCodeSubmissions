// https://leetcode.com/problems/longest-palindromic-subsequence

public class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        
        // Initialize dp array
        int[][] dp = new int[n][n];
        
        // Base case: single characters are palindromes of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        
        // Iterate through the string
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    // If characters at i and j match, the length of the palindrome increases by 2
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    // Otherwise, take the maximum of palindrome lengths by excluding either the left or right character
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // Return the length of the longest palindromic subsequence in the entire string
        return dp[0][n - 1];
    }
}