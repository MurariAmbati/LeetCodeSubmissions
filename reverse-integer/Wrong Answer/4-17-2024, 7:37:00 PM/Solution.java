// https://leetcode.com/problems/reverse-integer

public class Solution {
    public int reverse(int x) {
        long reversed = 0;
        int maxInt = Integer.MAX_VALUE;  // Maximum positive 32-bit integer
        int minInt = Integer.MIN_VALUE;  // Minimum negative 32-bit integer

        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;

            // Check for overflow using long to avoid truncation
            if (reversed > maxInt / 10 || (reversed == maxInt / 10 && digit > 7)) {
                return 0;
            }
            if (reversed < minInt / 10 || (reversed == minInt / 10 && digit < -8)) {
                return 0;
            }

            x /= 10;
        }

        return (int) reversed; // Cast back to int if no overflow
    }
}
