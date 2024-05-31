// https://leetcode.com/problems/convert-a-number-to-hexadecimal

class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        
        StringBuilder result = new StringBuilder();
        while (num != 0) {
            int remainder = num & 15; // equivalent to num % 16
            char hexDigit = (remainder < 10) ? (char) ('0' + remainder) : (char) ('a' + remainder - 10);
            result.insert(0, hexDigit);
            num >>>= 4; // equivalent to num / 16
        }
        
        return result.toString();
    }
}