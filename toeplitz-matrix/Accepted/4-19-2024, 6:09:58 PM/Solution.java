// https://leetcode.com/problems/toeplitz-matrix

public class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Iterate through each element starting from the second row and second column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // Check if the current element is equal to its top-left neighbor
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        
        // All elements match their top-left neighbor, so the matrix is Toeplitz
        return true;
    }
}