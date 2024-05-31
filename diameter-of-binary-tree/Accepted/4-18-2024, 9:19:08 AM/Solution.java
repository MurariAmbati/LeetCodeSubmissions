// https://leetcode.com/problems/diameter-of-binary-tree

class Solution {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateDiameter(root);
        return diameter;
    }

    private int calculateDiameter(TreeNode node) {
        if (node == null) return 0;
        
        int leftHeight = calculateDiameter(node.left);
        int rightHeight = calculateDiameter(node.right);
        
        diameter = Math.max(diameter, leftHeight + rightHeight);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
