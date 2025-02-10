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
    // Time Complexity: O(N) - Each node is visited exactly only once during the in-order traversal.
    // Space Complexity: O(H) - O(Log N) for a balanced BST, O(N) for a skewed BST.
    private TreeNode prev = null;
    private int answer = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        find (root);
        return answer;
    }
    private void find (TreeNode root) {
        if (root == null) return;
        
        find (root.left);
        if (prev != null)
            answer = Math.min(answer, Math.abs(root.val - prev.val));
        prev = root;
        find (root.right);
    }
    public int getMinimumDifferenceBruteforce(TreeNode root) {
        List<Integer> listInOrder = new ArrayList<>();
        inOrderTraversal(listInOrder, root);
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < listInOrder.size() - 1; i++) {
            answer = Math.min(answer, listInOrder.get(i + 1) - listInOrder.get(i));
        }
        return answer;
    }
    private void inOrderTraversal (List<Integer> listInOrder, TreeNode root) {
        if (root == null) return;
        inOrderTraversal(listInOrder, root.left);
        listInOrder.add(root.val);
        inOrderTraversal(listInOrder, root.right);
    }
}
