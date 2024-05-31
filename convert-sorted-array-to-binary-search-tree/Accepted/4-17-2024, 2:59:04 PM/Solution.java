// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode constructBST(int[] nums, int left, int right) {
        if (left > right) {
            return null; // Base case: Empty subtree.
        }
        int mid = left + (right - left) / 2; // Calculate middle index.
        TreeNode root = new TreeNode(nums[mid]); // Create a new node.
        root.left = constructBST(nums, left, mid - 1); // Recursively construct left subtree.
        root.right = constructBST(nums, mid + 1, right); // Recursively construct right subtree.
        return root;
    }
}
