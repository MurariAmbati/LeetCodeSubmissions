// https://leetcode.com/problems/maximum-product-of-three-numbers

class Solution {
    public int maximumProduct(int[] nums) {
        if (nums.length < 3) {
            throw new IllegalArgumentException("Input array must have at least 3 elements");
        }
        
        Arrays.sort(nums);
        return Math.max(nums[nums.length - 1] * nums[nums.length - 2] * nums[0], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }
}
