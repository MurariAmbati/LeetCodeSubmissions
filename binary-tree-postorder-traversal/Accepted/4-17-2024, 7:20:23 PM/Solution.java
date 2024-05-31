// https://leetcode.com/problems/binary-tree-postorder-traversal

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private void postorderHelper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorderHelper(root.left, result);
        postorderHelper(root.right, result);
        result.add(root.val);
    }
}
