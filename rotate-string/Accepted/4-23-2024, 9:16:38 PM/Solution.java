// https://leetcode.com/problems/rotate-string

class Solution {
    public boolean rotateString(String s, String goal) {
        // If the lengths of s and goal are different, return false
        if (s.length() != goal.length()) {
            return false;
        }
        
        // Concatenate s with itself
        String concatenated = s + s;
        
        // Check if goal is a substring of the concatenated string
        return concatenated.contains(goal);
    }
}