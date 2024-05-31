// https://leetcode.com/problems/sudoku-solver

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        if (col == board[0].length) {
            return solve(board, row + 1, 0); // Move to next row
        }
        if (row == board.length) {
            return true; // Reached end, Sudoku solved
        }

        if (board[row][col] != '.') {
            return solve(board, row, col + 1); // Skip filled cells
        }

        for (char num = '1'; num <= '9'; num++) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num;
                if (solve(board, row, col + 1)) {
                    return true; // Found solution with this placement
                }
                board[row][col] = '.'; // Backtrack if placement doesn't lead to solution
            }
        }
        return false; // No valid placement found in this cell
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        // Check row
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == num && i != col) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num && i != row) {
                return false;
            }
        }

        // Check sub-box
        int boxStartRow = (row / 3) * 3;
        int boxStartCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[boxStartRow + i][boxStartCol + j] == num &&
                        (boxStartRow + i != row || boxStartCol + j != col)) {
                    return false;
                }
            }
        }
        return true;
    }
}
