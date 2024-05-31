// https://leetcode.com/problems/container-with-most-water

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Calculate the width of the container
            int width = right - left;

            // Get the minimum height between the left and right lines
            int minHeight = Math.min(height[left], height[right]);

            // Calculate the current container area
            int currentArea = width * minHeight;

            // Update the maximum area if necessary
            maxArea = Math.max(maxArea, currentArea);

            // Move the shorter line towards the center
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
