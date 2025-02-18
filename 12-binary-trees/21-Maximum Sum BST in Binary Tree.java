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
    class SubTreeInfo {    
        boolean isBST;
        int maxLeft;
        int minRight;
        int sum; 
        public SubTreeInfo() {
            isBST = false;
            maxLeft = Integer.MIN_VALUE;
            minRight = Integer.MAX_VALUE;
            sum = 0;
        }
    }
    public int maxSumBST(TreeNode root) {
        traversePostOrder(root);
        return answer < 0 ? 0 : answer;
    }
    private SubTreeInfo traversePostOrder(TreeNode root) {
        if (root == null) {
            SubTreeInfo subTreeInfo = new SubTreeInfo();
            subTreeInfo.isBST = true;
            return subTreeInfo;
        }

        SubTreeInfo lstInfo = traversePostOrder(root.left);
        SubTreeInfo rstInfo = traversePostOrder(root.right);

        boolean isLSTBST = lstInfo.isBST;
        boolean isRSTBST = rstInfo.isBST;
        int lstMaxLeft = lstInfo.maxLeft;
        int lstMinRight = lstInfo.minRight;
        int rstMaxLeft = rstInfo.maxLeft;
        int rstMinRight = rstInfo.minRight; 

        SubTreeInfo subTreeInfo = new SubTreeInfo();
        subTreeInfo.sum = root.val;
        subTreeInfo.sum += lstInfo.sum;
        subTreeInfo.sum += rstInfo.sum;    
        if (root.val > lstMaxLeft && root.val < rstMinRight && isLSTBST && isRSTBST) {
            subTreeInfo.isBST = true;
            answer = Math.max(answer, subTreeInfo.sum);
        }
        subTreeInfo.maxLeft = Math.max(root.val , Math.max(lstMaxLeft, rstMaxLeft));
        subTreeInfo.minRight = Math.min(root.val, Math.min(lstMinRight, rstMinRight));
        return subTreeInfo;
    }   
}
