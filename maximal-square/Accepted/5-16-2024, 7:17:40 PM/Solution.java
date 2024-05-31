// https://leetcode.com/problems/maximal-square

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Initialize dp array
        int[][] dp = new int[m][n];
        
        // Initialize result to store the maximum square area
        int result = 0;
        
        // Initialize the first row and first column of the dp array
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
            result = Math.max(result, dp[i][0]);
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] - '0';
            result = Math.max(result, dp[0][j]);
        }
        
        // Compute dp values for the rest of the array
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        
        // Return the maximum square area
        return result * result;
    }
}