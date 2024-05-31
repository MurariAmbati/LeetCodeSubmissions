// https://leetcode.com/problems/3sum

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);  // Sort the array for efficient lookups

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { // Skip duplicate elements (i)
                continue;
            }
            int target = -nums[i];
            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                int sum = nums[low] + nums[high];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                } else if (sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return new ArrayList<>(result);
    }
}
