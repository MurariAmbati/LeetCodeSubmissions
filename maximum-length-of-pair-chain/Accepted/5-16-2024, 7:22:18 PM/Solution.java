// https://leetcode.com/problems/maximum-length-of-pair-chain

import java.util.Arrays;

public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]); // Sort pairs based on their second element
        
        int count = 1; // Initialize count to 1 because the first pair is always selected
        int prev = pairs[0][1]; // Initialize prev to the second element of the first pair
        
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > prev) {
                count++;
                prev = pairs[i][1];
            }
        }
        
        return count;
    }
}