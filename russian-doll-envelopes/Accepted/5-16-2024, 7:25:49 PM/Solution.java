// https://leetcode.com/problems/russian-doll-envelopes

import java.util.Arrays;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Sort the envelopes based on their widths in ascending order
        // If the widths are equal, sort based on the heights in descending order
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int n = envelopes.length;
        int[] dp = new int[n];
        int len = 0;

        // Iterate through the sorted envelopes array
        for (int[] envelope : envelopes) {
            int h = envelope[1];
            // Use binary search to find the correct position to insert the current envelope's height into the LIS array
            int left = 0, right = len;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (dp[mid] < h) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // If pos == len, increment len to represent the current LIS length
            if (left == len) {
                len++;
            }
            // Update dp[left] with the current envelope's height
            dp[left] = h;
        }

        return len;
    }

}