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
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode rootLeft = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(rootLeft);
        return root;    
    }
}
