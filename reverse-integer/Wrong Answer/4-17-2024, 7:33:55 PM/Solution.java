// https://leetcode.com/problems/reverse-integer

public class Solution {
    public int reverse(int x) {
        int reversed = 0;
        int maxInt = Integer.MAX_VALUE;  // Maximum positive 32-bit integer
        int minInt = Integer.MIN_VALUE;  // Minimum negative 32-bit integer

        while (x != 0) {
            int digit = x % 10;
            int newReversed = reversed * 10 + digit;

            // Check for overflow before adding the digit
            if ((newReversed > maxInt / 10) || (newReversed == maxInt / 10 && digit > 7)) {
                return 0;
            }
            if ((newReversed < minInt / 10) || (newReversed == minInt / 10 && digit < -8)) {
                return 0;
            }

            reversed = newReversed;
            x /= 10;
        }

        return reversed;
    }
}
