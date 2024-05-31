// https://leetcode.com/problems/range-sum-query-immutable

class NumArray {

    private int[] prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        // Return the sum between left (inclusive) and right (inclusive) using prefix sum
        return prefixSum[right + 1] - prefixSum[left];
    }
}
