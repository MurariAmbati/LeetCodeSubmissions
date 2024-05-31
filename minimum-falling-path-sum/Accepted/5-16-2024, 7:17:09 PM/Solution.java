// https://leetcode.com/problems/minimum-falling-path-sum

public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        
        // Initialize dp array to store minimum falling path sum
        int[][] dp = new int[n][n];
        
        // Copy the first row of the matrix to the dp array
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }
        
        // Iterate from the second row to the last row
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Initialize minPathSum with the value of the current element in the matrix
                int minPathSum = matrix[i][j];
                
                // Update minPathSum with the minimum falling path sum from the previous row
                minPathSum += dp[i - 1][j];
                if (j > 0) {
                    minPathSum = Math.min(minPathSum, dp[i - 1][j - 1] + matrix[i][j]);
                }
                if (j < n - 1) {
                    minPathSum = Math.min(minPathSum, dp[i - 1][j + 1] + matrix[i][j]);
                }
                
                // Update the dp array with the minimum falling path sum
                dp[i][j] = minPathSum;
            }
        }
        
        // Find the minimum falling path sum in the last row of the dp array
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, dp[n - 1][j]);
        }
        
        // Return the minimum falling path sum
        return minSum;
    }
}