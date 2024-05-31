// https://leetcode.com/problems/n-th-tribonacci-number

public class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }

        // Initialize variables for the first three numbers in the sequence
        int T0 = 0, T1 = 1, T2 = 1;

        // Compute Tn using dynamic programming
        for (int i = 3; i <= n; i++) {
            int Tn = T0 + T1 + T2;
            T0 = T1;
            T1 = T2;
            T2 = Tn;
        }

        return T2;
    }

}