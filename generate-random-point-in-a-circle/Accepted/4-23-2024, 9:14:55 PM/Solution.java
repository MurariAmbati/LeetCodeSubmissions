// https://leetcode.com/problems/generate-random-point-in-a-circle

import java.util.Random;

class Solution {
    double radius;
    double x_center;
    double y_center;
    Random rand;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        this.rand = new Random();
    }

    public double[] randPoint() {
        // Generate a random angle in radians
        double angle = rand.nextDouble() * 2 * Math.PI;
        // Generate a random radius in the range [0, radius]
        double r = Math.sqrt(rand.nextDouble()) * radius;
        // Calculate the Cartesian coordinates
        double x = x_center + r * Math.cos(angle);
        double y = y_center + r * Math.sin(angle);
        return new double[]{x, y};
    }
}
