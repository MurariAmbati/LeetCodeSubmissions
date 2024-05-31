// https://leetcode.com/problems/group-anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();  // Use HashMap for anagram groups
        for (String word : strs) {
            // Sort characters for anagram key
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);  // Convert char array to String

            anagrams.computeIfAbsent(sortedWord, key -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(anagrams.values());
    }
}
