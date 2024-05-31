// https://leetcode.com/problems/russian-doll-envelopes

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Sort the envelopes based on their widths in ascending order
        // If the widths are equal, sort based on the heights in descending order
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Initialize dp array with 1s

        int maxEnvelopes = 1;

        // Iterate through the sorted envelopes array
        for (int i = 1; i < n; i++) {
            // Iterate through the envelopes before it
            for (int j = 0; j < i; j++) {
                // If envelope[i] can fit into envelope[j]
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); // Update dp[i]
                }
            }
            maxEnvelopes = Math.max(maxEnvelopes, dp[i]); // Update maxEnvelopes
        }

        return maxEnvelopes;
    }
}