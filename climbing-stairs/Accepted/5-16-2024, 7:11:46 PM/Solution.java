// https://leetcode.com/problems/climbing-stairs

class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            // Use dynamic programming to store previously calculated results
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;

            // Iteratively calculate the number of ways for each step
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            return dp[n];
        }
    }
}
