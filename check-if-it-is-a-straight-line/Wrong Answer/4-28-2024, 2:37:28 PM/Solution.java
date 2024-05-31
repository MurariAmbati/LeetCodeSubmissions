// https://leetcode.com/problems/check-if-it-is-a-straight-line

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) {
            return true;
        }
        
        // Calculate the slope between the first two points
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];
        double initialSlope = (double)(y1 - y0) / (x1 - x0);
        
        // Check the slope between the remaining points
        for (int i = 2; i < coordinates.length; i++) {
            int xi = coordinates[i][0];
            int yi = coordinates[i][1];
            double slope = (double)(yi - y0) / (xi - x0);
            if (slope != initialSlope) {
                return false;
            }
        }
        
        return true;
    }
}
