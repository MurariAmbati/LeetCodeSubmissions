// https://leetcode.com/problems/count-ways-to-build-good-strings

class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int MOD = 1000000007;
        int[][] dp = new int[high + 1][2];

        dp[1][0] = 1;
        dp[1][1] = 1;

        for (int i = 2; i <= high; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
            dp[i][1] = dp[i - 1][0];
        }

        long result = 0;

        for (int i = low; i <= high; i++) {
            result += dp[i][0] + dp[i][1];
            result %= MOD;
        }

        return (int) result;
    }
}