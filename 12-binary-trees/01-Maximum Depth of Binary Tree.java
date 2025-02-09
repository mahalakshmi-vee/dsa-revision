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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int maxDepth = 0;
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        int bfsQueueSize = 0;
        int level = 0;
        while (!bfsQueue.isEmpty()) {
            bfsQueueSize = bfsQueue.size();
            level++;
            for (int i = 0; i < bfsQueueSize; i++) {
                TreeNode peekNode = bfsQueue.poll();
                if (isLeaf(peekNode)) {
                    maxDepth = Math.max(maxDepth, level);
                }
                if (peekNode.left != null) bfsQueue.add(peekNode.left);
                if (peekNode.right != null) bfsQueue.add(peekNode.right);
            }
        }
        return maxDepth;
    }
    private boolean isLeaf (TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
