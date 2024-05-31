// https://leetcode.com/problems/ones-and-zeroes

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        for (int i = 1; i <= strs.length; i++) {
            int[] count = countZerosOnes(strs[i - 1]);
            int countZero = count[0];
            int countOne = count[1];

            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j >= countZero && k >= countOne) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - countZero][k - countOne] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }

        return dp[strs.length][m][n];
    }

    private int[] countZerosOnes(String str) {
        int[] count = new int[2];
        for (char c : str.toCharArray()) {
            count[c - '0']++;
        }
        return count;
    }
}