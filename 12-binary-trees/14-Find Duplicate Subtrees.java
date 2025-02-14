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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, TreeNode> subTreeMap = new HashMap<>();
        Set<TreeNode> duplicates = new HashSet<>();
        inorder(root, subTreeMap, duplicates);
        return new ArrayList<>(duplicates);
    }
    private String inorder (TreeNode root, Map<String, TreeNode> subTreeMap, Set<TreeNode> duplicates) {
        if (root == null) return "null";

        String leftSerialized = inorder (root.left, subTreeMap, duplicates);
        String rightSerialized = inorder (root.right, subTreeMap, duplicates);
        String result = ("l"+leftSerialized) + ("t"+root.val) + ("r"+rightSerialized);
        if (subTreeMap.containsKey(result)) {
            duplicates.add(subTreeMap.get(result));
        }
        else {
            subTreeMap.put(result, root);
        }
        return result;
    }
}
