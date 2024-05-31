// https://leetcode.com/problems/1-bit-and-2-bit-characters

public class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 0) {
                // One-bit character
                i++;
            } else {
                // Two-bit character
                i += 2;
            }
        }
        // If i equals bits.length - 1, it means we've successfully decoded all bits
        // and the last character must be a one-bit character
        return i == bits.length - 1;
    }
}