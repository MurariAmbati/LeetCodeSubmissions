// https://leetcode.com/problems/number-of-1-bits

public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;  // Count the least significant set bit
            n >>= 1;          // Right shift n by 1 to check the next bit
        }
        return count;
    }
}
