// https://leetcode.com/problems/serialize-and-deserialize-bst

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.Arrays;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        serializeHelper(node.left, sb);
        sb.append(node.val).append(",");
        serializeHelper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] values = data.split(",");
        return deserializeHelper(values, 0, values.length - 1);
    }

    private TreeNode deserializeHelper(String[] values, int start, int end) {
        if (start > end) return null;
        TreeNode node = new TreeNode(Integer.parseInt(values[start]));
        int i;
        for (i = start + 1; i <= end; i++) {
            if (Integer.parseInt(values[i]) > node.val) {
                break;
            }
        }
        node.left = deserializeHelper(values, start + 1, i - 1);
        node.right = deserializeHelper(values, i, end);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;