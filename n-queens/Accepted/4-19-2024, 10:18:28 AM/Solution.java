// https://leetcode.com/problems/n-queens

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        solve(board, 0, solutions);
        return solutions;
    }

    private void solve(char[][] board, int col, List<List<String>> solutions) {
        if (col == board.length) {
            // Add a copy of the current board configuration as a solution
            solutions.add(copyBoard(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                solve(board, col + 1, solutions); // Recursively solve for next column
                board[row][col] = '.'; // Backtrack and reset the position
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        // Check for queens in the same row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }

        // Check for queens in diagonals (upward and downward)
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row + 1, j = col - 1; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> copyBoard(char[][] board) {
        List<String> boardStr = new ArrayList<>();
        for (char[] row : board) {
            boardStr.add(new String(row));
        }
        return boardStr;
    }
}
