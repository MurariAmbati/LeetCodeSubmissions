// https://leetcode.com/problems/recover-binary-search-tree

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
public class Solution {
    private TreeNode firstNode;
    private TreeNode secondNode;
    private TreeNode prevNode;
    
    public void recoverTree(TreeNode root) {
        firstNode = null;
        secondNode = null;
        prevNode = null;
        
        // Perform in-order traversal
        traverse(root);
        
        // Swap values of first and second nodes
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }
    
    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        
        // Traverse left subtree
        traverse(node.left);
        
        // Check for violation
        if (prevNode != null && prevNode.val > node.val) {
            if (firstNode == null) {
                firstNode = prevNode;
            }
            secondNode = node;
        }
        prevNode = node;
        
        // Traverse right subtree
        traverse(node.right);
    }
}