// https://leetcode.com/problems/projection-area-of-3d-shapes

class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int xyProjection = 0;
        int yzProjection = 0;
        int zxProjection = 0;

        // Calculate xyProjection (sum of maximum values in each row)
        for (int i = 0; i < n; i++) {
            int maxRow = 0;
            for (int j = 0; j < n; j++) {
                maxRow = Math.max(maxRow, grid[i][j]);
                if (grid[i][j] > 0) zxProjection++; // Count non-zero values for zxProjection
            }
            xyProjection += maxRow;
        }

        // Calculate yzProjection (sum of maximum values in each column)
        for (int j = 0; j < n; j++) {
            int maxCol = 0;
            for (int i = 0; i < n; i++) {
                maxCol = Math.max(maxCol, grid[i][j]);
            }
            yzProjection += maxCol;
        }

        return xyProjection + yzProjection + zxProjection;
    }
}