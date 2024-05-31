// https://leetcode.com/problems/divide-two-integers

public class Solution {
    public int divide(int dividend, int divisor) {
        // Handle special cases
        if (divisor == 0) {
            return Integer.MAX_VALUE; // Division by zero is undefined, return max value
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // Overflow case, return max value
        }

        // Convert signs to positive for easier handling
        boolean isNegative = (dividend > 0) ^ (divisor > 0);
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        // Perform bitwise shift-based division (efficient for large numbers)
        long quotient = 0;
        while (absDividend >= absDivisor) {
            int shift = 0;
            while (absDividend >= (absDivisor << shift)) {
                shift++;
            }
            quotient += (long) 1 << (shift - 1);
            absDividend -= absDivisor << (shift - 1);
        }

        // Apply original signs and handle overflow
        quotient = isNegative ? -quotient : quotient;
        if (quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (quotient < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) quotient;
    }
}
