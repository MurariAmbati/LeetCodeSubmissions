// https://leetcode.com/problems/reverse-words-in-a-string-iii

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" "); // Split the string into words
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            result.append(reverse(word)).append(" "); // Reverse each word and append it to the result
        }
        
        // Remove the trailing space and return the result
        return result.toString().trim();
    }
    
    private String reverse(String word) {
        char[] chars = word.toCharArray();
        int left = 0, right = chars.length - 1;
        
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        
        return new String(chars);
    }
}
