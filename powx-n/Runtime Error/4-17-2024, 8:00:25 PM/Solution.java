// https://leetcode.com/problems/powx-n

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;  // Handle n=0 case
        } else if (n < 0) {
            return 1.0 / pow(x, -n);  // Handle negative exponents efficiently
        } else {
            double result = 1.0;
            while (n > 0) {
                if ((n & 1) == 1) {  // Efficiently handle odd powers using bitwise AND
                    result *= x;
                }
                n >>>= 1;  // Right shift n by 1 for repeated squaring
                x *= x;  // Square x for even powers
            }
            return result;
        }
    }

    // Helper function for better readability (optional)
    private double pow(double x, int n) {
        return myPow(x, n);
    }
}
