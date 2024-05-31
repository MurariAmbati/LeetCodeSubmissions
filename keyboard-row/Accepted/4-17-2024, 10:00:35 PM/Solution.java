// https://leetcode.com/problems/keyboard-row

class Solution {
    public String[] findWords(String[] words) {
        // Create a map to map each character to its corresponding row
        Map<Character, Integer> rowMap = new HashMap<>();
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (int i = 0; i < rows.length; i++) {
            for (char c : rows[i].toCharArray()) {
                rowMap.put(c, i);
            }
        }
        
        List<String> resultList = new ArrayList<>();
        for (String word : words) {
            if (isSameRow(word.toLowerCase(), rowMap)) {
                resultList.add(word);
            }
        }
        
        return resultList.toArray(new String[0]);
    }
    
    private boolean isSameRow(String word, Map<Character, Integer> rowMap) {
        int row = rowMap.get(word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            if (rowMap.get(word.charAt(i)) != row) {
                return false;
            }
        }
        return true;
    }
}