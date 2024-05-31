// https://leetcode.com/problems/backspace-string-compare

class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skipS = 0, skipT = 0;
        
        while (i >= 0 || j >= 0) {
            // Find the next non-backspace character in s
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            
            // Find the next non-backspace character in t
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            
            // Compare characters at the current positions
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }
            
            // If one of the pointers is at a non-backspace character and the other is not,
            // or both pointers are not at a non-backspace character, return false
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            
            // Move to the next character
            i--;
            j--;
        }
        
        // Both strings match after typing into empty text editors
        return true;
    }
}