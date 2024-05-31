// https://leetcode.com/problems/base-7

class Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0";

        StringBuilder sb = new StringBuilder();
        boolean isNegative = num < 0;
        if (isNegative) num = -num;

        while (num > 0) {
            int remainder = num % 7;
            sb.append(remainder);
            num /= 7;
        }

        if (isNegative) sb.append("-");
        return sb.reverse().toString();
    }
}