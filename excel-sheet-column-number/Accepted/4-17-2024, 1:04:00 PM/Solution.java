// https://leetcode.com/problems/excel-sheet-column-number

class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (char c : columnTitle.toCharArray()) {
            int digit = c - 'A' + 1;
            result = result * 26 + digit;
        }
        return result;
    }
}
