// https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        List<Integer> course = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        
        for (int obstacle : obstacles) {
            int idx = binarySearch(course, obstacle);
            if (idx == course.size()) {
                course.add(obstacle);
            } else {
                course.set(idx, obstacle);
            }
            result.add(idx + 1);
        }
        
        // Convert List<Integer> to int[]
        int[] resArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArray[i] = result.get(i);
        }
        
        return resArray;
    }
    
    private int binarySearch(List<Integer> course, int target) {
        int left = 0, right = course.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (course.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}