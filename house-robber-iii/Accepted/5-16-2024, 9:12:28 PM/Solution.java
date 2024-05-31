// https://leetcode.com/problems/house-robber-iii

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
    public int rob(TreeNode root) {
        int[] result = robSub(root);
        return Math.max(result[0], result[1]);
    }
    
    private int[] robSub(TreeNode root) {
        if (root == null) return new int[2];
        
        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        
        // result[0] represents the maximum amount of money robbed without robbing the current node
        // result[1] represents the maximum amount of money robbed by robbing the current node
        int[] result = new int[2];
        
        // If we don't rob the current node, we can take the maximum of robbing or not robbing its children
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        // If we rob the current node, we cannot rob its children
        result[1] = root.val + left[0] + right[0];
        
        return result;
    }
}
