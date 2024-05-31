// https://leetcode.com/problems/palindrome-number

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            int digit = x % 10;
            revertedNumber = revertedNumber * 10 + digit;
            x /= 10;
        }

        // Handle cases where the original number might be a palindrome
        // even if revertedNumber is equal to it.
        // For example: x = 1221
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
