// https://leetcode.com/problems/perfect-squares

import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // Base case: 0 requires 0 perfect squares.
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            // Try all possible perfect square numbers less than or equal to i.
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}