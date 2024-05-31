// https://leetcode.com/problems/triangle

import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // Get the number of rows in the triangle
        int n = triangle.size();
        
        // Initialize the dp array to store the minimum path sum
        int[] dp = new int[n];
        
        // Initialize dp array with the values of the bottom row
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }
        
        // Iterate from the second last row to the top row
        for (int i = n - 2; i >= 0; i--) {
            // Update each element in the current row with the minimum path sum
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        
        // Return the minimum path sum from top to bottom
        return dp[0];
    }
}