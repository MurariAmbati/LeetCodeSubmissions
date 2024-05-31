// https://leetcode.com/problems/longest-arithmetic-subsequence

import java.util.*;

class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                int len = dp[j].getOrDefault(diff, 1) + 1;
                dp[i].put(diff, len);
                maxLen = Math.max(maxLen, len);
            }
        }
        
        return maxLen;
    }
}