// https://leetcode.com/problems/count-binary-substrings

public class Solution {
    public int countBinarySubstrings(String s) {
        int count = 0;
        int prevLength = 0;
        int currLength = 1;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currLength++;
            } else {
                count += Math.min(prevLength, currLength);
                prevLength = currLength;
                currLength = 1;
            }
        }
        
        // Add the minimum of prevLength and currLength for the last group
        count += Math.min(prevLength, currLength);
        
        return count;
    }
}