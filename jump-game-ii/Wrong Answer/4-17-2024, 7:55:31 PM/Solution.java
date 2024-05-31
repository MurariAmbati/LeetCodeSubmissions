// https://leetcode.com/problems/jump-game-ii

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int maxReach = nums[0];  // Maximum reachable index from current position
        int farthest = maxReach;  // Farthest reachable index seen so far
        int jumps = 0;  // Number of jumps made

        for (int i = 1; i < n - 1; i++) {
            // Handle the case where the current reach can't reach the end
            if (i > maxReach) {
                return -1;
            }
            
            // Update farthest reachable index and jumps if needed
            farthest = Math.max(farthest, i + nums[i]);
            if (i == maxReach) {
                jumps++;
                maxReach = farthest;
            }
        }

        return jumps + (farthest >= n - 1 ? 1 : 0);  // Check and add a jump for the last element
    }
}
