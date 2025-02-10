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
    // Time Complexity: O(N) - Each node is visited exactly once during the traversal.
    // Space Complexity: O(H) 
        // - O(Log N) when tree is balanced.
        // - O(N) when tree is skewed.
    public void flatten(TreeNode root) {
        
        flattenBT(root);
    }
    private TreeNode flattenBT(TreeNode root) {
        if (root == null) return root;

        TreeNode lst  = flattenBT(root.left);
        TreeNode rst = flattenBT(root.right);
        if (lst == null && rst != null) {
            root.right = rst;
        }
        else if (lst != null && rst == null) {
            root.right = lst;
            root.left = null;
        }
        else if (lst != null && rst != null) {
            TreeNode tailNode = findTail(lst);
            tailNode.right = root.right;
            root.right = lst;
            root.left = null;
        }
        return root;
    }
    private TreeNode findTail (TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}
