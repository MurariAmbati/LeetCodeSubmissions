// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);  // Track minimum price seen so far
            maxProfit = Math.max(maxProfit, price - minPrice);  // Update profit based on current and min price
        }

        return maxProfit;
    }
}
