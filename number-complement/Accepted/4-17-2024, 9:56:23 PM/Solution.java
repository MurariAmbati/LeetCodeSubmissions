// https://leetcode.com/problems/number-complement

class Solution {
    public int findComplement(int num) {
        // Find the number of bits required to represent num
        int bitCount = 0;
        int n = num;
        while (n > 0) {
            bitCount++;
            n >>= 1;
        }
        
        // Create a bitmask with all bits set to 1
        int bitmask = (1 << bitCount) - 1;
        
        // Perform a bitwise XOR operation to get the complement
        return num ^ bitmask;
    }
}