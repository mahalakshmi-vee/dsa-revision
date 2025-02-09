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
    // Space complexity: O(N ^ 2) (due to strin concatenation overhead)
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> listAnswer = new ArrayList<>();
        helper(root, new StringBuilder(), listAnswer);
        return listAnswer;
    }
    private void helper (TreeNode root, StringBuilder sb, List<String> listAnswer) {
        if (root != null && root.left == null && root.right == null) {
            String subAnswer = sb.toString() + root.val;
            listAnswer.add(subAnswer);
            return;
        } else if (root == null) {
            return;
        }
        int prevLength = sb.length();
        StringBuilder str = new StringBuilder(root.val + "->");
        sb.append(str.toString());
        helper(root.left, sb, listAnswer);
        helper(root.right, sb, listAnswer);
        sb.delete(prevLength, sb.length());
    }
}
