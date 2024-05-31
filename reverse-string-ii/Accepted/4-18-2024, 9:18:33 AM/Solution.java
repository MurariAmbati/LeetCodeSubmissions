// https://leetcode.com/problems/reverse-string-ii

class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = s.length();
        
        for (int i = 0; i < n; i += 2 * k) {
            reverse(chars, i, Math.min(i + k, n) - 1);
        }
        
        return new String(chars);
    }
    
    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}