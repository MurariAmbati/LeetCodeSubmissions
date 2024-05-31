// https://leetcode.com/problems/array-partition

import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {
        // Sort the array in non-decreasing order
        Arrays.sort(nums);
        
        // Initialize the sum of minimum elements in pairs
        int totalSum = 0;
        
        // Iterate over the sorted array and sum the minimum elements in pairs
        for (int i = 0; i < nums.length; i += 2) {
            totalSum += Math.min(nums[i], nums[i + 1]);
        }
        
        return totalSum;
    }
}
