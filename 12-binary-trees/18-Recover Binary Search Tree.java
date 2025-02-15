// Brute force approach:
// Time Complexity: O(NLogN)
// Space Complexity: O(N) (O(N) for the list and O(N) recursive call stack)
// class Solution {
//     private int index = 0;
//     public void recoverTree(TreeNode root) {
//         List<Integer> listNode = new ArrayList<>();
//         inorder(root, listNode);
//         Collections.sort(listNode);
//         helper(root, listNode);
//     }
//     private void inorder(TreeNode root, List<Integer> listNode) {
//         if (root == null) return;
//         inorder(root.left, listNode);
//         listNode.add(root.val);
//         inorder(root.right, listNode);
//     }
//     private void helper(TreeNode root, List<Integer> listNode) {
//         if (root == null) return;
//         helper(root.left, listNode);
//         if (root.val != listNode.get(index)) {
//             root.val = listNode.get(index);
//         }
//         index++;
//         helper(root.right, listNode);
//     }
// }

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
 // Time Complexity: O(N)
 // Space Complexity: O(N) 
class Solution {
    private TreeNode previousNode = null;
    private TreeNode firstNodeToSwap = null;
    private TreeNode secondNodeToSwap = null;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int val = firstNodeToSwap.val;
        firstNodeToSwap.val = secondNodeToSwap.val;
        secondNodeToSwap.val = val;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        if (previousNode != null && root.val < previousNode.val) {
            if (firstNodeToSwap == null) firstNodeToSwap = previousNode;
            secondNodeToSwap = root;
        }
        previousNode = root;
        inorder(root.right);
    }
}
