// https://leetcode.com/problems/reverse-bits

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reversed = 0;
        for (int i = 0; i < 32; i++) {
            // Get the rightmost bit of n (treated as unsigned)
            int bit = (n >> i) & 1;
            // Shift the reversed number left by 1 and add the current bit
            reversed = reversed << 1 | bit;
        }
        return reversed;
    }
}
