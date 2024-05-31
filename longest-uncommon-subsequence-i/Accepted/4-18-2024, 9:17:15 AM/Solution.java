// https://leetcode.com/problems/longest-uncommon-subsequence-i

class Solution {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1; // Both strings are equal, so there is no uncommon subsequence
        } else {
            return Math.max(a.length(), b.length()); // Length of the longer string is the longest uncommon subsequence
        }
    }
}