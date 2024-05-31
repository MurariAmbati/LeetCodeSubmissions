// https://leetcode.com/problems/simplify-path

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        // Split the path by '/'
        String[] dirs = path.split("/");

        // Process each directory
        for (String dir : dirs) {
            if (dir.equals("..")) {
                // Go one level up
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!dir.equals(".") && !dir.isEmpty()) {
                // Ignore '.' and empty strings
                stack.push(dir);
            }
        }

        // Construct the simplified canonical path
        StringBuilder sb = new StringBuilder("/");
        for (String dir : stack) {
            sb.append(dir).append("/");
        }

        // Remove the trailing '/'
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 1);
        }

        return sb.toString();
    }
}