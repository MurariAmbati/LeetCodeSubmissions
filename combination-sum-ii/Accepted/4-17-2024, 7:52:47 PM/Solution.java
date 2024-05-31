// https://leetcode.com/problems/combination-sum-ii

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);  // Sort candidates to avoid duplicate combinations
        
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
            // Skip duplicates (same candidate as previous but not at the same position)
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            currComb.add(candidates[i]);
            dfs(candidates, remaining - candidates[i], i + 1, currComb, results);  // Skip elements after the current one
            currComb.remove(currComb.size() - 1);
        }
    }
}
