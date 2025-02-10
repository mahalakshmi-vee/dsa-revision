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
    // Time complexity: O(N)
    // Space complexity: O(Log N)
    public TreeNode sortedArrayToBST(int[] nums) {

        return buildBST(nums, 0, nums.length - 1);
    }
    private TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) return null;
        int middle = (start + end) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = buildBST(nums, start, middle - 1);
        root.right = buildBST(nums, middle + 1, end);
        return root;
    }
}
