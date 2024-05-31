// https://leetcode.com/problems/length-of-last-word

class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        String trimmed = s.trim(); // Remove leading and trailing spaces
        for (int i = 0; i < trimmed.length(); i++) {
            if (trimmed.charAt(i) == ' ') {
                len = 0; // Reset length for each space
            } else {
                len++;
            }
        }
        return len;
    }
}
