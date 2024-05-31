// https://leetcode.com/problems/restore-ip-addresses

import java.util.*;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, new ArrayList<>(), result, 0);
        return result;
    }

    private void backtrack(String s, List<String> current, List<String> result, int start) {
        // If we have already found 4 parts and used all characters in s, add the IP address to the result
        if (current.size() == 4 && start == s.length()) {
            result.add(String.join(".", current));
            return;
        }
        
        // If we have already found 4 parts but still have characters left in s, return
        if (current.size() == 4 || start == s.length()) {
            return;
        }

        // Try adding dots at different positions and continue recursion
        for (int i = start; i < Math.min(start + 3, s.length()); i++) {
            String part = s.substring(start, i + 1);
            // Check if the part is valid (no leading zeros and within 0-255)
            if (isValid(part)) {
                current.add(part);
                backtrack(s, current, result, i + 1);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isValid(String part) {
        // Check if the part has no leading zeros and is within 0-255
        return !((part.length() > 1 && part.charAt(0) == '0') || Integer.parseInt(part) > 255);
    }

}