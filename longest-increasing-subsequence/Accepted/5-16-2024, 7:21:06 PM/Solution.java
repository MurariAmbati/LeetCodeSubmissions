// https://leetcode.com/problems/longest-increasing-subsequence

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int len = 0; // Length of the longest increasing subsequence found so far
        
        for (int num : nums) {
            int left = 0, right = len;
            // Binary search to find the smallest element in tails that is greater than or equal to num
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // Replace the found element with num or append num if it's greater than all elements in tails
            tails[left] = num;
            // If num is greater than all elements in tails, increment len
            if (left == len) {
                len++;
            }
        }
        
        return len;
    }
}