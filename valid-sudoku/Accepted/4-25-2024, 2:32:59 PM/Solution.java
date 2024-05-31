// https://leetcode.com/problems/valid-sudoku

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        
        // Check rows
        for (char[] row : board) {
            Set<Character> seen = new HashSet<>();
            for (char num : row) {
                if (num != '.' && seen.contains(num)) {
                    return false;
                }
                seen.add(num);
            }
        }
        
        // Check columns
        for (int col = 0; col < n; col++) {
            Set<Character> seen = new HashSet<>();
            for (int row = 0; row < n; row++) {
                char num = board[row][col];
                if (num != '.' && seen.contains(num)) {
                    return false;
                }
                seen.add(num);
            }
        }
        
        // Check sub-boxes
        for (int i = 0; i < n; i += 3) {
            for (int j = 0; j < n; j += 3) {
                Set<Character> seen = new HashSet<>();
                for (int row = i; row < i + 3; row++) {
                    for (int col = j; col < j + 3; col++) {
                        char num = board[row][col];
                        if (num != '.' && seen.contains(num)) {
                            return false;
                        }
                        seen.add(num);
                    }
                }
            }
        }
        
        return true;
    }
}
