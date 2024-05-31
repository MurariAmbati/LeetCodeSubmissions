// https://leetcode.com/problems/remove-duplicates-from-sorted-array

class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;  // Initialize a counter for unique elements

        if (nums.length == 0) {
            return count;  // Handle empty array
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[count]) {  // Check for duplicates
                count++;  // Increment count if unique element found
                nums[count] = nums[i];  // Move unique element to next position
            }
        }

        return count + 1;  // Return the count of unique elements (including the first)
    }
}
