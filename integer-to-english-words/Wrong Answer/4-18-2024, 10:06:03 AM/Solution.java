// https://leetcode.com/problems/integer-to-english-words

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // Define arrays for numbers, tens multiples, and powers of 10
    private static final String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] scales = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                result.insert(0, helper(num % 1000) + scales[i] + " ");
            }
            num /= 1000;
            i++;
        }

        return result.toString().trim();
    }

    // Helper function to convert a three-digit number to English words
    private String helper(int num) {
        StringBuilder sb = new StringBuilder();

        if (num >= 100) {
            sb.append(ones[num / 100]).append(" Hundred ");
            num %= 100;
        }

        if (num >= 20) {
            sb.append(tens[num / 10]).append(" ");
            num %= 10;
        }

        sb.append(ones[num]).append(" ");

        return sb.toString();
    }
}