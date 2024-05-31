// https://leetcode.com/problems/number-of-segments-in-a-string

class Solution {
    public int countSegments(String s) {
        int count = 0;
        boolean inSegment = false;
        
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (inSegment) {
                    count++;
                    inSegment = false;
                }
            } else {
                inSegment = true;
            }
        }
        
        // Check if the last character was part of a segment
        if (inSegment) {
            count++;
        }
        
        return count;
    }
}