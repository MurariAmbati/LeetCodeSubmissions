// https://leetcode.com/problems/license-key-formatting

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        // Remove dashes and convert to uppercase
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != '-') {
                sb.append(Character.toUpperCase(c));
            }
        }
        
        // Insert dashes every k characters from the end
        int len = sb.length();
        for (int i = len - k; i > 0; i -= k) {
            sb.insert(i, '-');
        }
        
        return sb.toString();
    }
}