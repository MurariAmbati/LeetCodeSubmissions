// https://leetcode.com/problems/longest-palindrome

class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128]; // Assuming ASCII characters
        
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        
        int length = 0;
        boolean oddFound = false;
        
        for (int f : freq) {
            length += f / 2 * 2;
            if (f % 2 == 1) {
                oddFound = true;
            }
        }
        
        return oddFound ? length + 1 : length;
    }

}
