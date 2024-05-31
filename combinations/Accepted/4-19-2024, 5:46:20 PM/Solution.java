// https://leetcode.com/problems/combinations

import java.util.*;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, k, 1);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> temp, int n, int k, int start) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            temp.add(i);
            backtrack(result, temp, n, k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}