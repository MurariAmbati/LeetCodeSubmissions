// https://leetcode.com/problems/valid-anagram

class Solution {
    public boolean isAnagram(String s, String t) {
         if (s.length() != t.length()) {
            return false; // Different lengths cannot be anagrams
        }
        
        // Option 1: Using Character Counting (HashMap)
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return false;
            }
            charCount.put(c, charCount.get(c) - 1);
        }
        return charCount.values().stream().allMatch(count -> count == 0);

        // Option 2: Using Sorting (potentially less efficient for large strings)
        // char[] sChars = s.toCharArray();
        // char[] tChars = t.toCharArray();
        // Arrays.sort(sChars);
        // Arrays.sort(tChars);
        // return Arrays.equals(sChars, tChars);
    }
}