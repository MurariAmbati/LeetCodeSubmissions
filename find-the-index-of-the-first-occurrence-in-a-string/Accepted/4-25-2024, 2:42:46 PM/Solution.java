// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string

class Solution {
    public int strStr(String haystack, String needle) {
        // Handle edge cases
        if (needle.isEmpty()) {
            return 0; // Empty needle, return 0
        }
        if (haystack.length() < needle.length()) {
            return -1; // Needle is longer than haystack, not possible
        }
        
        // Iterate through the haystack
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean found = true;
            // Check if needle matches the substring starting at index i
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    found = false;
                    break; // Mismatch, move to the next position
                }
            }
            if (found) {
                return i; // Found the needle at index i
            }
        }
        
        return -1; // Needle not found in haystack
    }
}
