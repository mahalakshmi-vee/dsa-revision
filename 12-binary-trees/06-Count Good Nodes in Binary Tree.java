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
    // Time Complexity: O(N) - Each node is visited exactly once during the DFS traversal.
    // Space Complexity: O(H), where H is the height of the tree.
    //     - O(Log N) for a balanced BST (since recursion depth is Log N)
    //     - O(N) for a skewed BST (recursion depth reaches N in worst case)
    private int goodNodesCount = 0; 
    public int goodNodes(TreeNode root) {
        find (root, root.val);
        return goodNodesCount;
    }
    private void find (TreeNode root, int maxValue) {
        if (root == null) return;
        if (root.val >= maxValue) goodNodesCount++;
        find (root.left, Math.max(maxValue, root.val));
        find (root.right, Math.max(maxValue, root.val));
    }
}
