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
// Brute force approach:
// Time Complexity: O(N ^ 2)
// Space Complexity: O(N)
// class Solution {
//     private int maxSum = Integer.MIN_VALUE;
//     public int maxSumBST(TreeNode root) {
//         inorder(root);
//         return maxSum < 0 ? 0 : maxSum;
//     }
//     private void inorder (TreeNode root) {
//         if (root == null) return;
//         inorder(root.left);
//         if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
//             maxSum = Math.max(maxSum, sum(root));
//         }
//         inorder(root.right);
//     }
//     private boolean isLeaf(TreeNode root) {
//         return root != null && root.left == null && root.right == null;
//     }
//     private boolean isBST (TreeNode root, int minValue, int maxValue) {
//         if (root == null) return true;

//         if (root.val >= minValue && root.val <= maxValue) {
//             return isBST(root.left, minValue, root.val - 1) && isBST(root.right, root.val + 1, maxValue);
//         }

//         return false;
//     }
//     private int sum(TreeNode root) {
//         if (root == null) return 0;

//         return root.val + sum(root.left) + sum(root.right);
//     }
// }
