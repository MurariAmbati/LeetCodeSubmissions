// https://leetcode.com/problems/positions-of-large-groups

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                if (i - start >= 3) {
                    List<Integer> interval = new ArrayList<>();
                    interval.add(start);
                    interval.add(i - 1);
                    result.add(interval);
                }
                start = i;
            }
        }
        // Check the last group
        if (s.length() - start >= 3) {
            List<Integer> interval = new ArrayList<>();
            interval.add(start);
            interval.add(s.length() - 1);
            result.add(interval);
        }
        return result;
    }
}