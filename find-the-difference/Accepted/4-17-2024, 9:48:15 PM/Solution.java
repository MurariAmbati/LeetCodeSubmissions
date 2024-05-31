// https://leetcode.com/problems/find-the-difference

class Solution {
    public char findTheDifference(String s, String t) {
        int[] charCount = new int[26];
        
        // Count the frequency of each character in string s
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        // Update the frequency for each character in string t
        for (char c : t.toCharArray()) {
            charCount[c - 'a']--;
        }
        
        // Find the character with different frequency
        for (int i = 0; i < 26; i++) {
            if (charCount[i] < 0) {
                return (char) (i + 'a');
            }
        }
        
        // This line should never be reached
        return ' '; 
    }
}