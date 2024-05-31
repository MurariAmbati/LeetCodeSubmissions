// https://leetcode.com/problems/find-mode-in-binary-search-tree

class Solution {
    private int prevVal;
    private int count;
    private int maxCount;
    private List<Integer> modes;

    public int[] findMode(TreeNode root) {
        prevVal = 0;
        count = 0;
        maxCount = 0;
        modes = new ArrayList<>();

        inOrderTraversal(root);

        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) return;

        inOrderTraversal(node.left);

        // Compare current value with previous value
        if (node.val == prevVal) {
            count++;
        } else {
            count = 1;
            prevVal = node.val;
        }

        // Update max count and result list
        if (count > maxCount) {
            maxCount = count;
            modes.clear();
            modes.add(node.val);
        } else if (count == maxCount) {
            modes.add(node.val);
        }

        inOrderTraversal(node.right);
    }
}