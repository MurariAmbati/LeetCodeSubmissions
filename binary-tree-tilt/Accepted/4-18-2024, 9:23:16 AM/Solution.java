// https://leetcode.com/problems/binary-tree-tilt

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
    int tiltSum = 0;
    
    public int findTilt(TreeNode root) {
        postOrder(root);
        return tiltSum;
    }
    
    private int postOrder(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        // Calculate the sum of left subtree and right subtree
        int leftSum = postOrder(node.left);
        int rightSum = postOrder(node.right);
        
        // Calculate the tilt of the current node and update the tiltSum
        tiltSum += Math.abs(leftSum - rightSum);
        
        // Return the sum of values of the current subtree rooted at 'node'
        return leftSum + rightSum + node.val;
    }
}
