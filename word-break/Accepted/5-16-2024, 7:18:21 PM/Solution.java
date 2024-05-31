// https://leetcode.com/problems/word-break

import java.util.*;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Create a set to store words from wordDict for efficient lookup
        Set<String> wordSet = new HashSet<>(wordDict);
        
        // Initialize dp array
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // An empty string can always be segmented
        
        // Iterate through each position in the string
        for (int i = 1; i <= s.length(); i++) {
            // Iterate through each word in wordDict
            for (String word : wordDict) {
                // Check if the current word ends at position i and if the substring before that can be segmented
                if (i >= word.length() && dp[i - word.length()] && s.substring(i - word.length(), i).equals(word)) {
                    dp[i] = true; // Update dp[i] to true
                    break; // No need to check other words if the current word is found
                }
            }
        }
        
        // Return the value of dp[s.length()], which represents whether the entire string can be segmented
        return dp[s.length()];
    }
}