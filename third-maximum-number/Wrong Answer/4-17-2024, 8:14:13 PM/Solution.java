// https://leetcode.com/problems/third-maximum-number

class Solution {
    public int thirdMax(int[] nums) {
        if (nums.length < 3) {
            return Arrays.stream(nums).max().getAsInt();
        }
        
        Arrays.sort(nums);
        int distinctMaxCount = 0;
        int prev = nums[nums.length - 1];
        
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < prev) {
                distinctMaxCount++;
                prev = nums[i];
                if (distinctMaxCount == 3) {
                    return prev;
                }
            }
        }
        return prev; // Return maximum if third distinct max doesn't exist
    }
}
