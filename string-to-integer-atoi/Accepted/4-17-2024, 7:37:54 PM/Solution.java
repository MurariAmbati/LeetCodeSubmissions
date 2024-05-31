// https://leetcode.com/problems/string-to-integer-atoi

public class Solution {
    public int myAtoi(String s) {
        int result = 0;
        int sign = 1;
        int index = 0;
        int n = s.length();

        // Skip leading whitespace
        while (index < n && Character.isSpaceChar(s.charAt(index))) {
            index++;
        }

        // Check for sign
        if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index) == '+') ? 1 : -1;
            index++;
        }

        // Read digits
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // Check for overflow
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }
}
