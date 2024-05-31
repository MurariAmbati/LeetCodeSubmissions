// https://leetcode.com/problems/permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        permute(nums, 0, results);
        return results;
    }
    
    private void permute(int[] nums, int startIndex, List<List<Integer>> results) {
        if (startIndex == nums.length) {
            List<Integer> currPerm = new ArrayList<>();
            for (int num : nums) {
                currPerm.add(num);
            }
            results.add(currPerm);
            return;
        }
        
        for (int i = startIndex; i < nums.length; i++) {
            // Swap elements to create new orderings
            swap(nums, startIndex, i);
            permute(nums, startIndex + 1, results);
            swap(nums, startIndex, i);  // Backtrack and swap back
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
