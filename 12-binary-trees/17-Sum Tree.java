/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
// Time Complexity: O(N), since each node is visited exactly once.
// Space Complexity: O(N) in the worst case (skewed tree), and O(Log N) in the best case (balanced tree)
class Solution {
    boolean isSumTree(Node root) {
        return sum(root) != -1;
    }
    private static int sum (Node root) {
        if (isLeaf(root)) return root.data;
        else if (root == null) return 0;
        
        int lstSum = sum(root.left);
        int rstSum = sum(root.right);
        if (lstSum == -1 || rstSum == -1 || (lstSum + rstSum != root.data)) {
            return -1;
        }
        
        return root.data + lstSum + rstSum;
    }
    private static boolean isLeaf(Node node) {
        return node != null && node.left == null && node.right == null;
    }
}
