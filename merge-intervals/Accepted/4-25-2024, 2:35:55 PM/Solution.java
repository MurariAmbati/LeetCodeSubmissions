// https://leetcode.com/problems/merge-intervals

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));  // Sort intervals by starting points

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];  // Initialize with the first interval

        for (int[] interval : intervals) {
            if (interval[0] <= current[1]) {  // Check for overlap
                current[1] = Math.max(current[1], interval[1]);  // Merge overlapping intervals
            } else {
                merged.add(current);  // No overlap, add previous interval to merged list
                current = interval;  // Start a new interval
            }
        }

        merged.add(current);  // Add the last interval (might not have been merged)

        return merged.toArray(new int[merged.size()][2]);  // Convert list to 2D array
    }
}
