// https://leetcode.com/problems/reshape-the-matrix

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        
        // Check if reshape operation is possible
        if (m * n != r * c) {
            return mat;
        }
        
        // Initialize the reshaped matrix
        int[][] reshaped = new int[r][c];
        
        // Fill the reshaped matrix with elements of the original matrix
        for (int i = 0; i < m * n; i++) {
            reshaped[i / c][i % c] = mat[i / n][i % n];
        }
        
        return reshaped;
    }
}
