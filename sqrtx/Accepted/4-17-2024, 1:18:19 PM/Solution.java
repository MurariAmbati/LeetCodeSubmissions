// https://leetcode.com/problems/sqrtx

class Solution {
    public int mySqrt(int x) {
        long low = 0;
        long high = x;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long square = mid * mid;

            if (square == x) {
                return (int) mid;  // Exact square root found
            } else if (square < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int) high;  // Return rounded down square root
    }
}
