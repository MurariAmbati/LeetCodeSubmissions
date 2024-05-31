// https://leetcode.com/problems/two-sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i : nums)
        {
            for(int j = i+1; j<nums.length; j++)
            {
                if(nums[j]+nums[i]==target)
                    return new int[] {i, j};
            }
        }
        return null;
    }
}