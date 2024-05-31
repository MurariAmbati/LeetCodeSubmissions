// https://leetcode.com/problems/symmetric-tree

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true; // An empty tree is symmetric.
        }
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true; // Both nodes are null, so they are symmetric.
        }
        if (left == null || right == null) {
            return false; // One node is null, they are not symmetric.
        }
        // Check if the values of the current nodes are equal.
        if (left.val != right.val) {
            return false;
        }
        // Recursively check the left child of the left subtree with the right child of the right subtree,
        // and vice versa.
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
