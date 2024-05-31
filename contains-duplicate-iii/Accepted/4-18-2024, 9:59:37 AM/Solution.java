// https://leetcode.com/problems/contains-duplicate-iii

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length < 2 || indexDiff <= 0) {
            return false;
        }
        
        TreeSet<Long> treeSet = new TreeSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = treeSet.ceiling((long) nums[i] - (long) valueDiff);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) valueDiff) {
                return true;
            }
            
            treeSet.add((long) nums[i]);
            
            if (i >= indexDiff) {
                treeSet.remove((long) nums[i - indexDiff]);
            }
        }
        
        return false;
    }
}