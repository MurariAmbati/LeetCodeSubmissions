// https://leetcode.com/problems/combination-sum

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        
        dfs(candidates, target, 0, new ArrayList<>(), results);
        return results;
    }
    
    private void dfs(int[] candidates, int remaining, int startIndex, List<Integer> currComb, List<List<Integer>> results) {
        if (remaining == 0) {
            results.add(new ArrayList<>(currComb));  // Add a copy to avoid modifications
            return;
        }
        
        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] > remaining) {
                break;
            }
            currComb.add(candidates[i]);
            dfs(candidates, remaining - candidates[i], i, currComb, results);  // Don't skip elements
            currComb.remove(currComb.size() - 1);
        }
    }
}
