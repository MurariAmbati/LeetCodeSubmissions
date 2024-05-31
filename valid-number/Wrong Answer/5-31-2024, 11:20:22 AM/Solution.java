// https://leetcode.com/problems/valid-number

public class Solution {
    public boolean isNumber(String s) {
        // Trim the string to remove leading and trailing whitespaces
        s = s.trim();
        
        // Check if the string is empty after trimming
        if (s.length() == 0) {
            return false;
        }
        
        // Split the string into base and exponent parts if an exponent is present
        int eIndex = Math.max(s.indexOf('e'), s.indexOf('E'));
        if (eIndex != -1) {
            String base = s.substring(0, eIndex);
            String exponent = s.substring(eIndex + 1);
            return isValidBase(base) && isValidExponent(exponent);
        } else {
            return isValidBase(s);
        }
    }
    
    private boolean isValidBase(String s) {
        // Check if the base contains a dot
        int dotIndex = s.indexOf('.');
        if (dotIndex != -1) {
            String left = s.substring(0, dotIndex);
            String right = s.substring(dotIndex + 1);
            return (isValidInteger(left, true) || left.isEmpty()) && (isValidInteger(right, false) || right.isEmpty());
        } else {
            return isValidInteger(s, true);
        }
    }
    
    private boolean isValidExponent(String s) {
        // Check if the exponent is a valid integer (with an optional sign)
        return isValidInteger(s, true);
    }
    
    private boolean isValidInteger(String s, boolean allowSign) {
        if (s.length() == 0) {
            return false;
        }
        int start = 0;
        if (allowSign && (s.charAt(0) == '+' || s.charAt(0) == '-')) {
            start = 1;
        }
        if (start == s.length()) {
            return false;
        }
        for (int i = start; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}