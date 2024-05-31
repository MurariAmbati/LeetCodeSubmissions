// https://leetcode.com/problems/teemo-attacking

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int totalDuration = 0;
        
        // Iterate through the timeSeries array
        for (int i = 0; i < timeSeries.length; i++) {
            // Add the duration unless the current attack overlaps with the previous poison effect
            if (i == 0 || timeSeries[i] - timeSeries[i - 1] >= duration) {
                totalDuration += duration;
            } else {
                totalDuration += timeSeries[i] - timeSeries[i - 1];
            }
        }
        
        return totalDuration;
    }
}
