// https://leetcode.com/problems/assign-cookies

import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int contentChildren = 0;
        int gIndex = 0;
        int sIndex = 0;
        
        while (gIndex < g.length && sIndex < s.length) {
            if (s[sIndex] >= g[gIndex]) {
                contentChildren++;
                gIndex++;
            }
            sIndex++;
        }
        
        return contentChildren;
    }

}
