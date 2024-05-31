// https://leetcode.com/problems/jump-game

public class Solution {
    public boolean canJump(int[] nums) {
        int maxReachable = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (i > maxReachable) {
                return false; // Cannot proceed further
            }
            maxReachable = Math.max(maxReachable, i + nums[i]);
            if (maxReachable >= n - 1) {
                return true; // Reached the last index
            }
        }
        
        return false; // Unable to reach the last index
    }
}
