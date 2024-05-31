// https://leetcode.com/problems/word-search

public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, boolean[][] visited, int row, int col, int idx) {
        if (idx == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(idx)) {
            return false;
        }
        
        visited[row][col] = true;
        if (backtrack(board, word, visited, row + 1, col, idx + 1)
           || backtrack(board, word, visited, row - 1, col, idx + 1)
           || backtrack(board, word, visited, row, col + 1, idx + 1)
           || backtrack(board, word, visited, row, col - 1, idx + 1)) {
            return true;
        }
        visited[row][col] = false;
        return false;
    }
}