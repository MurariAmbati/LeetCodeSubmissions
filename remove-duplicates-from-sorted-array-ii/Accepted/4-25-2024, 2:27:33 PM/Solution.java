// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        
        int writeIdx = 2;
        for (int readIdx = 2; readIdx < nums.length; readIdx++) {
            if (nums[readIdx] != nums[writeIdx - 2]) {
                nums[writeIdx++] = nums[readIdx];
            }
        }
        
        return writeIdx;
    }
}