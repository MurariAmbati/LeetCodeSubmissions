// https://leetcode.com/problems/surface-area-of-3d-shapes

class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int totalArea = 0;

        // Iterate through each cell in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int height = grid[i][j];
                if (height > 0) {
                    // Top and bottom faces
                    totalArea += 2;

                    // Left face
                    if (j == 0 || grid[i][j - 1] < height) {
                        totalArea += height;
                    }

                    // Right face
                    if (j == n - 1 || grid[i][j + 1] < height) {
                        totalArea += height;
                    }

                    // Front face
                    if (i == 0 || grid[i - 1][j] < height) {
                        totalArea += height;
                    }

                    // Back face
                    if (i == n - 1 || grid[i + 1][j] < height) {
                        totalArea += height;
                    }
                }
            }
        }

        return totalArea;
    }

}