// https://leetcode.com/problems/number-of-digit-one

public class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        long divisor = 1;

        while (divisor <= n) {
            long quotient = n / (divisor * 10);
            long remainder = n % (divisor * 10);
            
            // Count the number of occurrences of digit 1 in the current place value
            count += quotient * divisor;
            if (remainder >= 2 * divisor) {
                count += divisor;
            } else if (remainder >= divisor) {
                count += remainder - divisor + 1;
            }

            divisor *= 10; // Move to the next significant digit
        }

        return count;
    }
}