// https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLength = 1; // Minimum length of the subsequence is 1
        
        for (int num : arr) {
            int prev = num - difference;
            int length = dp.getOrDefault(prev, 0) + 1; // Length of subsequence ending at num
            
            dp.put(num, length);
            maxLength = Math.max(maxLength, length);
        }
        
        return maxLength;
    }
}