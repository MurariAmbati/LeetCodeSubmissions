// https://leetcode.com/problems/delete-and-earn

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int deleteAndEarn(int[] nums) {
        // Build a frequency map of all numbers
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + num);
        }
        
        // Initialize variables for the previous number, points earned by skipping and taking the current number
        int prev = -1, skip = 0, take = 0;
        
        // Iterate through each number from 1 to the maximum number in the array
        for (int i = 1; i <= 10000; i++) {
            // Compute the maximum points by considering two cases: deleting the current number or skipping it
            int maxPoints = Math.max(skip, take);
            int freq = freqMap.getOrDefault(i, 0);
            take = freq + skip;
            skip = maxPoints;
        }
        
        // Return the maximum points earned
        return Math.max(skip, take);
    }
}