// https://leetcode.com/problems/intersection-of-two-arrays

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        
        // Add elements from nums1 to a set for efficient lookups
        for (int num : nums1) {
            set1.add(num);
        }
        
        // Iterate through nums2 and add elements to intersection if found in set1
        for (int num : nums2) {
            if (set1.contains(num)) {
                intersection.add(num);
            }
        }
        
        // Convert intersection set to a sorted array and return
        int[] result = new int[intersection.size()];
        int i = 0;
        for (int num : intersection) {
            result[i++] = num;
        }
        return result;
    }
}
