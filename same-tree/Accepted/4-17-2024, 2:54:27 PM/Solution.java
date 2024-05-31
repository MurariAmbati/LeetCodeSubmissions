// https://leetcode.com/problems/same-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case: If both nodes are null, they are equal.
        if (p == null && q == null) {
            return true;
        }
        // If one of the nodes is null, they are not equal.
        if (p == null || q == null) {
            return false;
        }
        // Check if the values of the current nodes are equal.
        if (p.val != q.val) {
            return false;
        }
        // Recursively check left and right subtrees.
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
