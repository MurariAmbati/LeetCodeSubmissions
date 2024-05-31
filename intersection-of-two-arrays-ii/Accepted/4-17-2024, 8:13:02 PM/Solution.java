// https://leetcode.com/problems/intersection-of-two-arrays-ii

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        // Count frequencies of elements in nums1
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // Iterate through nums2 and add elements to result based on frequency in map
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                result.add(num);
                map.put(num, count - 1); // Decrement frequency in map
            }
        }
        
        // Convert result list to int array and return
        int[] resultArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }
}
