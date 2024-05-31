// https://leetcode.com/problems/excel-sheet-column-title

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // Adjust to 0-based index
            char currentChar = (char) ('A' + columnNumber % 26);
            result.insert(0, currentChar);
            columnNumber /= 26;
        }

        return result.toString();
    }
}
