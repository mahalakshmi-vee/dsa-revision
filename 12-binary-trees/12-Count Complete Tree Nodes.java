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
    public int countNodes(TreeNode root) {
        int nodesCount = 0;
        if (root == null) return nodesCount;
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        int bfsQueueSize = 0;
        while (!bfsQueue.isEmpty()) {
            bfsQueueSize = bfsQueue.size();
            for (int i = 0; i < bfsQueueSize; i++) {
                TreeNode peekNode = bfsQueue.poll();
                nodesCount++;
                if (peekNode.left != null) bfsQueue.add(peekNode.left);
                if (peekNode.right != null) bfsQueue.add(peekNode.right);
            } 
        }
        return nodesCount;
    }
}
