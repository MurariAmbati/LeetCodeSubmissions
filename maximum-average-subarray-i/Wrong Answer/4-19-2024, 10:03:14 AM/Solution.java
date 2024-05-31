// https://leetcode.com/problems/maximum-average-subarray-i

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return 0.0; // Handle empty array or k = 0
        }
        
        double maxAverage = Double.MIN_VALUE;
        double windowSum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            windowSum += nums[i];
            if (i >= k - 1) {
                // Calculate average for the current window
                double currentAverage = windowSum / k;
                maxAverage = Math.max(maxAverage, currentAverage);
                windowSum -= nums[i - k + 1]; // Slide window
            }
        }
        return maxAverage;
    }
}
