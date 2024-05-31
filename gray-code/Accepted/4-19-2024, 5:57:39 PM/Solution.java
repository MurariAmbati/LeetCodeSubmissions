// https://leetcode.com/problems/gray-code

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> graySequence = new ArrayList<>();
        graySequence.add(0); // Base case for n = 0
        for (int i = 1; i < (1 << n); i++) {
            graySequence.add(i ^ (i >> 1));
        }
        return graySequence;
    }
}