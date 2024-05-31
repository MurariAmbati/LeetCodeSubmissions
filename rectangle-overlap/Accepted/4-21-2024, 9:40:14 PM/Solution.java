// https://leetcode.com/problems/rectangle-overlap

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // Check if rec1 is to the left of rec2
        if (rec1[2] <= rec2[0]) return false;
        // Check if rec1 is to the right of rec2
        if (rec1[0] >= rec2[2]) return false;
        // Check if rec1 is above rec2
        if (rec1[3] <= rec2[1]) return false;
        // Check if rec1 is below rec2
        if (rec1[1] >= rec2[3]) return false;
        
        // If none of the above conditions are met, the rectangles overlap
        return true;
    }
}