// https://leetcode.com/problems/burst-balloons

public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // Create a new array with padded 1s at both ends
        int[] paddedNums = new int[n + 2];
        paddedNums[0] = paddedNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            paddedNums[i + 1] = nums[i];
        }
        
        int[][] dp = new int[n + 2][n + 2];
        
        // Iterate over all possible lengths of subarrays
        for (int len = 1; len <= n; len++) {
            // Iterate over all possible starting points of subarrays
            for (int left = 1; left <= n - len + 1; left++) {
                int right = left + len - 1;
                // Iterate over all possible bursting points within the subarray
                for (int k = left; k <= right; k++) {
                    // Burst balloon at index k, update dp[left][right]
                    dp[left][right] = Math.max(dp[left][right], 
                                               dp[left][k - 1] + 
                                               paddedNums[left - 1] * paddedNums[k] * paddedNums[right + 1] + 
                                               dp[k + 1][right]);
                }
            }
        }
        return dp[1][n];
    }
}