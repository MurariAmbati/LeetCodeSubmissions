// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> used = new HashMap<>(); // Track characters seen and their last indices
        int maxLen = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // If the character is already in the used map and within the current window
            if (used.containsKey(ch) && used.get(ch) >= start) {
                // Shift the start of the window to the position after the last occurrence of the character
                start = Math.max(start, used.get(ch) + 1);
            } else {
                // Update the max_length if the current window is longer
                maxLen = Math.max(maxLen, i - start + 1);
            }
            // Update the last seen index for the current character
            used.put(ch, i);
        }

        return maxLen;
    }
}
