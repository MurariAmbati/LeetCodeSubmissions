// https://leetcode.com/problems/longest-arithmetic-subsequence

public class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n]; // dp[i][j] stores the length of the longest arithmetic subsequence ending at nums[i] with common difference nums[j] - nums[i]
        int maxLength = 2; // Minimum length of the subsequence is 2
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j]; // Calculate the common difference
                dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1); // Update the length of the subsequence
                maxLength = Math.max(maxLength, dp[i][diff]); // Update the maximum length
            }
        }
        
        return maxLength;
    }
}