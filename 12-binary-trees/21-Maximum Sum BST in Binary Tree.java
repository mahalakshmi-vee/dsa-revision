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
// Optimized approach
// Time complexity: O(N)
// Space complexity: O(N)
class Solution {
    private int answer = Integer.MIN_VALUE;
    class Pair {    
        boolean isBST = false;
        int maxLeft = Integer.MIN_VALUE;
        int minRight = Integer.MAX_VALUE;
        int sum = 0; 
        public Pair() {}
    }
    public int maxSumBST(TreeNode root) {
        postOrder(root);
        return answer < 0 ? 0 : answer;
    }
    private Pair postOrder(TreeNode root) {
        if (root == null) return null;

        Pair leftPair = postOrder(root.left);
        Pair rightPair = postOrder(root.right);

        boolean isLSTBST = leftPair == null ? true : leftPair.isBST;
        boolean isRSTBST = rightPair == null ? true : rightPair.isBST;
        int lstMaxLeft = leftPair == null ? Integer.MIN_VALUE : leftPair.maxLeft;
        int lstMinRight = leftPair == null ? Integer.MAX_VALUE : leftPair.minRight;
        int rstMaxLeft = rightPair == null ? Integer.MIN_VALUE : rightPair.maxLeft;
        int rstMinRight = rightPair == null ? Integer.MAX_VALUE : rightPair.minRight; 

        Pair pair = new Pair();
        pair.sum = root.val;
        if (leftPair != null) pair.sum += leftPair.sum;
        if (rightPair != null) pair.sum += rightPair.sum;    
        if (root.val > lstMaxLeft && root.val < rstMinRight && isLSTBST && isRSTBST) {
            pair.isBST = true;
            answer = Math.max(answer, pair.sum);
        }
        pair.maxLeft = Math.max(root.val , Math.max(lstMaxLeft, rstMaxLeft));
        pair.minRight = Math.min(root.val, Math.min(lstMinRight, rstMinRight));
        return pair;
    }   
}
