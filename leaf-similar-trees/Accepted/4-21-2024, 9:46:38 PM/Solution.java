// https://leetcode.com/problems/leaf-similar-trees

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder leafSeq1 = new StringBuilder();
        StringBuilder leafSeq2 = new StringBuilder();
        collectLeafValues(root1, leafSeq1);
        collectLeafValues(root2, leafSeq2);
        return leafSeq1.toString().equals(leafSeq2.toString());
    }
    
    private void collectLeafValues(TreeNode root, StringBuilder leafSeq) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leafSeq.append(root.val).append(",");
        }
        collectLeafValues(root.left, leafSeq);
        collectLeafValues(root.right, leafSeq);
    }

}