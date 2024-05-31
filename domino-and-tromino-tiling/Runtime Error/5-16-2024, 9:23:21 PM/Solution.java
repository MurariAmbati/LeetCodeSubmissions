// https://leetcode.com/problems/domino-and-tromino-tiling

class Solution {
    public int numTilings(int n) {
        int MOD = 1000000007;
        if (n <= 2) return n;
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD; // Regular tiling
            
            // T-shaped and upside-down T-shaped tilings
            dp[i] = (dp[i] + dp[i - 3]) % MOD;
            
            // L-shaped tiling
            dp[i] = (dp[i] + dp[i - 2]) % MOD;
            
            // Square-shaped tiling
            dp[i] = (dp[i] + dp[i - 4]) % MOD;
        }
        
        return dp[n];
    }
}