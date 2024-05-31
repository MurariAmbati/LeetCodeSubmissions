// https://leetcode.com/problems/perfect-rectangle

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        // Initialize a set to store the corners of all rectangles
        Set<String> corners = new HashSet<>();
        // Initialize the total area
        int totalArea = 0;
        
        for (int[] rect : rectangles) {
            int x1 = rect[0], y1 = rect[1], x2 = rect[2], y2 = rect[3];
            // Calculate the area of the current rectangle
            totalArea += (x2 - x1) * (y2 - y1);
            
            // Add the corners of the rectangle to the set
            String topLeft = x1 + "," + y1;
            String topRight = x2 + "," + y1;
            String bottomLeft = x1 + "," + y2;
            String bottomRight = x2 + "," + y2;
            corners.add(topLeft);
            corners.add(topRight);
            corners.add(bottomLeft);
            corners.add(bottomRight);
        }
        
        // Calculate the area of the bounding rectangle
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        for (String corner : corners) {
            String[] coords = corner.split(",");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);
            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
        }
        int boundingArea = (maxX - minX) * (maxY - minY);
        
        // Check if the total area matches the bounding rectangle area
        return totalArea == boundingArea;
    }
}
