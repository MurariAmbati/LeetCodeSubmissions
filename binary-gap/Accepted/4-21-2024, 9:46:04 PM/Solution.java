// https://leetcode.com/problems/binary-gap

class Solution {
    public int binaryGap(int n) {
        String binaryStr = Integer.toBinaryString(n);
        int maxDistance = 0;
        int prevOneIndex = -1;
        
        for (int i = 0; i < binaryStr.length(); i++) {
            if (binaryStr.charAt(i) == '1') {
                if (prevOneIndex != -1) {
                    maxDistance = Math.max(maxDistance, i - prevOneIndex);
                }
                prevOneIndex = i;
            }
        }
        
        return maxDistance;
    }

}