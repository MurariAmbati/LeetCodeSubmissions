// https://leetcode.com/problems/binary-number-with-alternating-bits

public class Solution {
    public boolean hasAlternatingBits(int n) {
        int prevBit = n & 1; // Get the rightmost bit
        n >>= 1; // Shift right to get the next bit
        while (n > 0) {
            int currBit = n & 1; // Get the next bit
            if (currBit == prevBit) {
                return false; // If adjacent bits are the same, return false
            }
            prevBit = currBit;
            n >>= 1; // Shift right to get the next bit
        }
        return true; // If all adjacent bits are different, return true
    }
}