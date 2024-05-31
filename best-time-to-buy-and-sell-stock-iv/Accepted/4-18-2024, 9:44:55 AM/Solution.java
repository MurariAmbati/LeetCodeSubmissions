// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv

public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k <= 0) {
            return 0;
        }
        
        int n = prices.length;
        if (k >= n / 2) {
            // If k is large enough to perform unlimited transactions,
            // we can just calculate the total profit by buying at each
            // local minimum and selling at each local maximum.
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }
        
        int[][] dp = new int[n][k + 1];
        
        for (int j = 1; j <= k; j++) {
            int maxDiff = -prices[0];
            for (int i = 1; i < n; i++) {
                dp[i][j] = Math.max(dp[i - 1][j], prices[i] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[i][j - 1] - prices[i]);
            }
        }
        
        return dp[n - 1][k];
    }
    

}
