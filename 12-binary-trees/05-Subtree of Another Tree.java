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
    // Time complexity: O(N + M)
    // Space complexity: O(N + M)
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder r = new StringBuilder();
        traverse(root, r);
        StringBuilder sr = new StringBuilder();
        traverse(subRoot, sr);
        return r.toString().contains(sr.toString());
    }
    private void traverse (TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null");
            return;
        }
        sb.append("node"+root.val);
        traverse(root.left, sb);
        traverse(root.right, sb);
    }
}
