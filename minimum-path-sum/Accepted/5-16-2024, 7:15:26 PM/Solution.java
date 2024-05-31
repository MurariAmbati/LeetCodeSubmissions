// https://leetcode.com/problems/minimum-path-sum

public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Create a 2D array to store the minimum sum of all numbers along the path
        int[][] dp = new int[m][n];

        // Initialize the minimum sum for the top-left cell
        dp[0][0] = grid[0][0];

        // Initialize the minimum sum for the first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Initialize the minimum sum for the first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // Calculate the minimum sum for each cell
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        // Return the minimum sum to reach the bottom-right corner
        return dp[m - 1][n - 1];
    }
}