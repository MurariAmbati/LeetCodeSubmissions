// https://leetcode.com/problems/delete-and-earn

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int deleteAndEarn(int[] nums) {
        // Count the frequency of each number
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Initialize variables for the previous number and points earned by skipping and taking the current number
        int prev = -1, skip = 0, take = 0;
        
        // Iterate through each unique number in ascending order
        for (int num : freqMap.keySet()) {
            // Compute the maximum points by considering two cases: deleting the current number or skipping it
            int maxPoints = Math.max(skip, take);
            
            // If the current number is adjacent to the previous number, update skip and take accordingly
            if (num - 1 != prev) {
                take = num * freqMap.get(num) + maxPoints;
                skip = maxPoints;
            } else {
                take = num * freqMap.get(num) + skip;
                skip = maxPoints;
            }
            
            // Update the previous number
            prev = num;
        }
        
        // Return the maximum points earned
        return Math.max(skip, take);
    }
}