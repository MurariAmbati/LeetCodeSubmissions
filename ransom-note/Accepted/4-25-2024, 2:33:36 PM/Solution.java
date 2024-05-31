// https://leetcode.com/problems/ransom-note

import java.util.*;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charCount = new HashMap<>();
        
        // Count the frequency of each character in magazine
        for (char c : magazine.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Check if ransomNote can be constructed using characters from magazine
        for (char c : ransomNote.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) <= 0) {
                return false; // Character not found or count becomes negative
            }
            charCount.put(c, charCount.get(c) - 1);
        }
        
        return true;
    }
}