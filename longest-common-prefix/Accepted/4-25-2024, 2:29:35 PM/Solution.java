// https://leetcode.com/problems/longest-common-prefix

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return ""; // Empty input or no strings
        }
        
        // Initialize the common prefix with the first string
        String commonPrefix = strs[0];
        
        // Iterate through the remaining strings
        for (int i = 1; i < strs.length; i++) {
            String currentString = strs[i];
            
            // Compare characters of the common prefix and the current string
            int j = 0;
            while (j < commonPrefix.length() && j < currentString.length() &&
                   commonPrefix.charAt(j) == currentString.charAt(j)) {
                j++;
            }
            
            // Update the common prefix based on the comparison
            commonPrefix = commonPrefix.substring(0, j);
            
            // If the common prefix becomes empty, break the loop
            if (commonPrefix.isEmpty()) {
                break;
            }
        }
        
        return commonPrefix;
    }
}
