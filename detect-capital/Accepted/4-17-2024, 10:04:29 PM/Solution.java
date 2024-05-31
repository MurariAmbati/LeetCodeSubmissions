// https://leetcode.com/problems/detect-capital

class Solution {
    public boolean detectCapitalUse(String word) {
        int countCapital = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                countCapital++;
            }
        }
        
        // All letters are capitals or all are lowercase
        if (countCapital == word.length() || countCapital == 0) {
            return true;
        }
        
        // Only the first letter is capital
        return countCapital == 1 && Character.isUpperCase(word.charAt(0));
    }
}