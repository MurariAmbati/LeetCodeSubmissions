// https://leetcode.com/problems/path-sum

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;  // Base case: Empty tree
        }
        return dfs(root, targetSum, 0);
    }

    private boolean dfs(TreeNode node, int targetSum, int currentSum) {
        currentSum += node.val;
        // If it's a leaf node and the current sum matches the target, return True
        if (node.left == null && node.right == null && currentSum == targetSum) {
            return true;
        }
        // Otherwise, recursively check left and right subtrees
        if (node.left != null && dfs(node.left, targetSum, currentSum)) {
            return true;
        }
        if (node.right != null && dfs(node.right, targetSum, currentSum)) {
            return true;
        }
        return false;
    }
}
