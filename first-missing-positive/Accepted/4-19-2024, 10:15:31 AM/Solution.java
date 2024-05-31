// https://leetcode.com/problems/first-missing-positive

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // In-place modification to utilize the array elements
        for (int i = 0; i < n; i++) {
            // Check if the current element is within the valid range (1 to n)
            // and is not already in its correct position (i.e., nums[i] = i + 1)
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                // Swap the element with the element at its correct position
                int j = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        
        // Find the first element that doesn't match its index (i.e., nums[i] != i + 1)
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        // If all elements are in their correct positions, the missing number is n + 1
        return n + 1;
    }
}
