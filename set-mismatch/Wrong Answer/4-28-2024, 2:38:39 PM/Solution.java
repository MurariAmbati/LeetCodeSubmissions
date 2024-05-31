// https://leetcode.com/problems/set-mismatch

class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int expectedSum = (n * (n + 1)) / 2;
        int actualSum = 0;
        int missingNumber = 0;
        
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            actualSum += num;
            if (seen.contains(num)) {
                return new int[]{num, missingNumber + expectedSum - actualSum};
            }
            seen.add(num);
        }
        
        // Handle edge case where all numbers are duplicated (no missing number)
        return new int[]{nums[0], expectedSum - actualSum + 1};
    }
}
