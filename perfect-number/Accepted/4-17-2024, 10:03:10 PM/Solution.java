// https://leetcode.com/problems/perfect-number

class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }
        
        int sum = 1; // 1 is always a divisor
        
        // Iterate from 2 to square root of num
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) { // Add the other divisor if it's not equal to the square root
                    sum += num / i;
                }
            }
        }
        
        // Check if the sum of divisors equals num
        return sum == num;
    }
}