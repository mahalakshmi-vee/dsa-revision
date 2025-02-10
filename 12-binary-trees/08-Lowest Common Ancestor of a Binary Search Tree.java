/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    // Time Complexity: O(N) - Each node is visited exactly once during the traversal.
    // Space Complexity: O(H), where H is the height of the tree.
        // - O(Log N) when the for a balanced tree (since height is Log N).
        // - O(N) for a skewed tree (in the worst case recursion depth reaches N).
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca (root, p, q);
    }
    private TreeNode lca (TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        else if (root.val == p.val || root.val == q.val) return root;

        TreeNode lst = lca(root.left, p, q);
        TreeNode rst = lca(root.right, p, q);

        if (lst != null && rst != null) return root;
        return lst == null ? rst : lst;
    }
}
