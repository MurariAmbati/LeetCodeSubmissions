// https://leetcode.com/problems/construct-the-rectangle

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] constructRectangle(int area) {
        List<int[]> rectangles = new ArrayList<>();
        
        // Find factors of the area
        for (int i = 1; i <= Math.sqrt(area); i++) {
            if (area % i == 0) {
                rectangles.add(new int[]{area / i, i});
            }
        }
        
        // Find the pair that satisfies the requirements
        int[] result = rectangles.get(rectangles.size() - 1); // Initialize with the last pair
        int minDifference = Math.abs(result[0] - result[1]);
        for (int[] rectangle : rectangles) {
            int difference = Math.abs(rectangle[0] - rectangle[1]);
            if (rectangle[0] >= rectangle[1] && difference < minDifference) {
                minDifference = difference;
                result = rectangle;
            }
        }
        
        return result;
    }
}