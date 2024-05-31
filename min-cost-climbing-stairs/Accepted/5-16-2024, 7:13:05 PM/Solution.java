// https://leetcode.com/problems/min-cost-climbing-stairs

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        // Base cases
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        // Compute minimum cost for each step
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        
        // Return minimum cost of reaching the top floor
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}