// https://leetcode.com/problems/search-insert-position

class Solution {
    public int searchInsert(int[] nums, int target) {
            int value = 0;
            if(target>nums[nums.length-1])
            {
                value = nums.length;
            }
            else
            {
                for(int i = 0; i<nums.length; i++)
                {
                    if(nums[i]<target && target<nums[i+1])
                    {
                        value = i+1;
                    }
                }
            }
             for(int i = 0; i<nums.length; i++)
                {
                    if(nums[i]==target)
                        value = i;
                }


            return value;


        
            
    }
}