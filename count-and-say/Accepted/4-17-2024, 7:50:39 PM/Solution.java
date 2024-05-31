// https://leetcode.com/problems/count-and-say

class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        
        String prev = countAndSay(n - 1);
        StringBuilder curr = new StringBuilder();
        char prevChar = prev.charAt(0);
        int count = 1;
        for (int i = 1; i < prev.length(); i++) {
            char currChar = prev.charAt(i);
            if (currChar == prevChar) {
                count++;
            } else {
                curr.append(count).append(prevChar);
                prevChar = currChar;
                count = 1;
            }
        }
        curr.append(count).append(prevChar); // Add the last character and its count
        return curr.toString();
    }
}
