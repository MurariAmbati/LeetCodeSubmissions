// https://leetcode.com/problems/longest-harmonious-subsequence

public class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        int longestSubsequenceLength = 0;
        for (int num : frequencyMap.keySet()) {
            if (frequencyMap.containsKey(num + 1)) {
                longestSubsequenceLength = Math.max(longestSubsequenceLength, frequencyMap.get(num) + frequencyMap.get(num + 1));
            }
        }
        
        return longestSubsequenceLength;
    }
}