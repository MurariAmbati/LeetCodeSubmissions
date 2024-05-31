// https://leetcode.com/problems/isomorphic-strings

class Solution {
    public boolean isIsomorphic(String s, String t) {
         if (s.length() != t.length()) {
            return false; // Strings must have the same length to be isomorphic
        }
        
        HashMap<Character, Character> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            if (charMap.containsKey(c1)) {
                if (charMap.get(c1) != c2) {
                    return false; // Inconsistent mapping for a character in s
                }
            } else {
                if (charMap.containsValue(c2)) {
                    return false; // Character in t already mapped to another character in s
                }
                charMap.put(c1, c2);
            }
        }
        return true;
    }
}