// https://leetcode.com/problems/image-smoother

class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] result = new int[m][n];

        // Iterate through each pixel in the image
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                int total = 0;
                // Iterate over the 3x3 filter neighbors
                for (int di = -1; di <= 1; di++) {
                    for (int dj = -1; dj <= 1; dj++) {
                        int new_i = i + di;
                        int new_j = j + dj;
                        // Check if neighbor is within image bounds
                        if (0 <= new_i && new_i < m && 0 <= new_j && new_j < n) {
                            count++;
                            total += img[new_i][new_j];
                        }
                    }
                }
                // Calculate average (rounded down) and set smoothed value
                result[i][j] = count > 0 ? total / count : 0;
            }
        }

        return result;
    }
}
