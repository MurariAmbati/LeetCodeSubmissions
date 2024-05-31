// https://leetcode.com/problems/move-zeroes

class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i]; // Swap non-zero element with the current zero position
                }
                j++;
            }
        }
        // Fill the remaining elements with 0 from j to the end
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }
}
