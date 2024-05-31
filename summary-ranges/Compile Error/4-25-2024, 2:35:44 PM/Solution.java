// https://leetcode.com/problems/summary-ranges

class Solution {
    public String[] summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new String[0];
        }

        List<String> result = new ArrayList<>();
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                // Encountered a gap, add the previous range
                result.add(start == nums[i - 1] ? String.valueOf(start) : start + "->" + nums[i - 1]);
                start = nums[i];
            }
        }
        // Add the last range
        result.add(start == nums[nums.length - 1] ? String.valueOf(start) : start + "->" + nums[nums.length - 1]);

        return result.toArray(new String[result.size()]);
    }
}
