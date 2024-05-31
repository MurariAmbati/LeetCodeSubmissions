// https://leetcode.com/problems/buddy-strings

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean buddyStrings(String s, String goal) {
        // Lengths of s and goal should be equal
        if (s.length() != goal.length()) return false;
        
        // If s and goal are equal, we need at least two repeating characters
        if (s.equals(goal)) {
            Set<Character> seen = new HashSet<>();
            for (char ch : s.toCharArray()) {
                if (seen.contains(ch)) {
                    return true;
                }
                seen.add(ch);
            }
            return false;
        }
        
        // Find the differences between s and goal
        int diff1 = -1, diff2 = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (diff1 == -1) {
                    diff1 = i;
                } else if (diff2 == -1) {
                    diff2 = i;
                } else {
                    // More than two differences found, early return false
                    return false;
                }
            }
        }
        
        // If there are exactly two differences, check if swapping them results in goal
        return (diff2 != -1 && s.charAt(diff1) == goal.charAt(diff2) && s.charAt(diff2) == goal.charAt(diff1));
    }

}