// https://leetcode.com/problems/permutation-sequence

public class Solution {
    public String getPermutation(int n, int k) {
        // Precompute factorials
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        // Convert k to zero-based index
        k--;

        // Initialize the numbers list
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        // Build the k-th permutation
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int index = k / factorial[i - 1];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k %= factorial[i - 1];
        }

        return sb.toString();
    }
}