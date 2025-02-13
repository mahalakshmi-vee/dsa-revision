/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Example 1:
// Serialized String: ~1~2~3~null~null~4~null~null~null~null
// Deserialized treenode values are as follows: ["", "1", "2", "3", "null", "null", "4", "null", "null", "null", "null"]
// Time Complexity: O(N)
// Space Complexity: O(N)
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        int bfsQueueSize = 0;
        StringBuilder serializedStr = new StringBuilder();
        while (!bfsQueue.isEmpty()) {
            bfsQueueSize = bfsQueue.size();
            for (int i = 0; i < bfsQueueSize; i++) {
                TreeNode peekNode = bfsQueue.poll();
                serializedStr.append("~"+ (peekNode == null ? "null" : peekNode.val));
                if (peekNode != null) {
                    bfsQueue.add(peekNode.left);
                    bfsQueue.add(peekNode.right);
                }
            }
        }
        return serializedStr.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] nodeValues = data.trim().split("~");
        TreeNode root = new TreeNode(Integer.valueOf(nodeValues[1]));
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        int bfsQueueSize = bfsQueue.size();
        int index = 2;
        while (!bfsQueue.isEmpty()) {
            bfsQueueSize = bfsQueue.size();
            for (int i = 0; i < bfsQueueSize; i++) {
                TreeNode peekNode = bfsQueue.poll();
                int leftChildIndex = index;
                int rightChildIndex = index + 1;
                if (leftChildIndex < nodeValues.length) {
                    if (nodeValues[leftChildIndex].equals("null"))
                        peekNode.left = null;
                    else {
                        peekNode.left = new TreeNode(Integer.valueOf(nodeValues[leftChildIndex]));
                        bfsQueue.add(peekNode.left);
                    }
                    index++;
                }
                if (rightChildIndex < nodeValues.length) {
                    if (nodeValues[rightChildIndex].equals("null")) 
                        peekNode.right = null;
                    else {
                        peekNode.right = new TreeNode(Integer.valueOf(nodeValues[rightChildIndex]));
                        bfsQueue.add(peekNode.right);
                    }
                    index++;
                }
            }
        }
        return root;     
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

