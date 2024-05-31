// https://leetcode.com/problems/n-queens-ii

class Solution {
    int count = 0;

    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n]; // To keep track of used columns
        boolean[] diag1 = new boolean[2 * n - 1]; // To keep track of used diagonals (upward)
        boolean[] diag2 = new boolean[2 * n - 1]; // To keep track of used diagonals (downward)
        solve(0, cols, diag1, diag2, n);
        return count;
    }

    private void solve(int row, boolean[] cols, boolean[] diag1, boolean[] diag2, int n) {
        if (row == n) {
            count++; // Increment count for a valid solution (all queens placed)
            return;
        }

        for (int col = 0; col < n; col++) {
            int index1 = row + col; // Index for upward diagonal
            int index2 = row - col + n - 1; // Index for downward diagonal

            if (!cols[col] && !diag1[index1] && !diag2[index2]) {
                cols[col] = true;
                diag1[index1] = true;
                diag2[index2] = true;

                solve(row + 1, cols, diag1, diag2, n);

                cols[col] = false;
                diag1[index1] = false;
                diag2[index2] = false;
            }
        }
    }
}
