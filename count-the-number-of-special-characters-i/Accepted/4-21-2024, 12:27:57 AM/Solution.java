// https://leetcode.com/problems/count-the-number-of-special-characters-i

public class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] lowercase = new boolean[26];
        boolean[] uppercase = new boolean[26];
        int count = 0;

        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lowercase[ch - 'a'] = true;
            } else if (Character.isUpperCase(ch)) {
                uppercase[ch - 'A'] = true;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (lowercase[i] && uppercase[i]) {
                count++;
            }
        }

        return count;
    }
}
