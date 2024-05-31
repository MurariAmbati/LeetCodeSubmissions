// https://leetcode.com/problems/3sum-closest

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);  // Sort the array for efficient lookups

        int closestSum = nums[0] + nums[1] + nums[2];  // Initialize with first three elements

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { // Skip duplicate elements (i)
                continue;
            }
            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                int currentSum = nums[i] + nums[low] + nums[high];
                int diff = Math.abs(currentSum - target);  // Absolute difference

                if (diff == 0) {  // If exact match found, return directly
                    return currentSum;
                } else if (diff < Math.abs(closestSum - target)) {  // Update closest sum if difference is smaller
                    closestSum = currentSum;
                }

                if (currentSum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return closestSum;
    }
}
