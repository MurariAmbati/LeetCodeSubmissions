// https://leetcode.com/problems/substring-with-concatenation-of-all-words


public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        
        int wordLength = words[0].length();
        int totalWordsLength = words.length * wordLength;
        
        if (s.length() < totalWordsLength) {
            return result;
        }
        
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        for (int i = 0; i <= s.length() - totalWordsLength; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < words.length) {
                int wordIndex = i + j * wordLength;
                String currentWord = s.substring(wordIndex, wordIndex + wordLength);
                if (!wordCount.containsKey(currentWord)) {
                    break;
                }
                seen.put(currentWord, seen.getOrDefault(currentWord, 0) + 1);
                if (seen.get(currentWord) > wordCount.get(currentWord)) {
                    break;
                }
                j++;
            }
            if (j == words.length) {
                result.add(i);
            }
        }
        
        return result;
    }
}