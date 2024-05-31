// https://leetcode.com/problems/valid-parentheses

class Solution {
    public boolean isValid(String s) {
        // Create a stack to store opening brackets
        Stack<Character> stack = new Stack<>();
        
        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                // If it's an opening bracket, push it onto the stack
                stack.push(c);
            } else {
                // If it's a closing bracket, check if it matches the top of the stack
                if (stack.isEmpty()) {
                    return false; // No matching opening bracket
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false; // Mismatched brackets
                }
            }
        }
        
        // If the stack is empty, all brackets matched correctly
        return stack.isEmpty();
    }
}
