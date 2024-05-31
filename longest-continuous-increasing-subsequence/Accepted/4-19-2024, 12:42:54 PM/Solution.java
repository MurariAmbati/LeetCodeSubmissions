// https://leetcode.com/problems/longest-continuous-increasing-subsequence

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxLength = 1;  // Initialize with 1 for single element subsequences

        // Base case: First element has LCIS of length 1
        dp[0] = 1;

        // Iterate through the array from the second element
        for (int i = 1; i < n; i++) {
            // Check if current element is greater than the previous element
            if (nums[i] > nums[i - 1]) {
                // Build on the LCIS ending at the previous element (dp[i-1] + 1)
                dp[i] = dp[i - 1] + 1;
            } else {
                // Start a new LCIS of length 1
                dp[i] = 1;
            }
            // Update maxLength if the current LCIS is longer
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
