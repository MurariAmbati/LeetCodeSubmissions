// https://leetcode.com/problems/range-addition-ii


public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int min_x = m;
        int min_y = n;
        
        for (int[] op : ops) {
            min_x = Math.min(min_x, op[0]);
            min_y = Math.min(min_y, op[1]);
        }
        
        return min_x * min_y;
    }
}