// https://leetcode.com/problems/letter-combinations-of-a-phone-number

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(digits, 0, "", map, result);
        return result;
    }

    private void backtrack(String digits, int index, String combination, Map<Character, String> map, List<String> result) {
        if (index == digits.length()) {
            result.add(combination);
            return;
        }

        char digit = digits.charAt(index);
        String letters = map.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            char letter = letters.charAt(i);
            backtrack(digits, index + 1, combination + letter, map, result);
        }
    }
}
