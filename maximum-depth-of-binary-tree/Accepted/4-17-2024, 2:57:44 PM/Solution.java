// https://leetcode.com/problems/maximum-depth-of-binary-tree

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0; // An empty tree has depth 0.
        }
        // Recursively compute the depth of the left and right subtrees.
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        // Return the maximum depth among the left and right subtrees, plus 1 for the current node.
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
