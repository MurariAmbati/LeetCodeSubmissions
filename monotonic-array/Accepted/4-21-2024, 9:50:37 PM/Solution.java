// https://leetcode.com/problems/monotonic-array

class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;

        // Check if the array is monotone increasing
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                increasing = false;
                break;
            }
        }

        // Check if the array is monotone decreasing
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                decreasing = false;
                break;
            }
        }

        // If either increasing or decreasing is true, return true
        return increasing || decreasing;
    }
}