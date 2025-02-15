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
 // Time Complexity: O(N ^ 2)
 // Space Complexity: O(N)
class Solution {
    class Pair {
        TreeNode node;
        int distance;
        public Pair (TreeNode node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    private Map<TreeNode, TreeNode> nodesParentMap = new HashMap<>();
    private int answer = 0;
    public int countPairs(TreeNode root, int distance) {
        prepareNodesParentMapUsingInorderTraversal(root);
        findGoodPairsUsingInOrderTraversal(root, distance);
        return answer / 2;
    }
    private void prepareNodesParentMapUsingInorderTraversal(TreeNode root) {
        if (root == null) return;
        prepareNodesParentMapUsingInorderTraversal(root.left);
        if (root.left != null) {
            nodesParentMap.put(root.left, root);
        }
        if (root.right != null) {
            nodesParentMap.put(root.right, root);
        }
        prepareNodesParentMapUsingInorderTraversal(root.right);
    }
    private void findGoodPairsUsingInOrderTraversal(TreeNode root, int distance) {
        if (root == null) return;
        findGoodPairsUsingInOrderTraversal(root.left, distance);
        if (isLeaf(root)) { // Represents a leaf node
            startBFS(root, distance);
        }
        findGoodPairsUsingInOrderTraversal(root.right, distance);
    }
    private void startBFS(TreeNode leafNode, int distance) {
        Queue<Pair> bfsQueue = new LinkedList<>();
        bfsQueue.add(new Pair(leafNode, 0));
        int bfsQueueSize = 0;
        Set<TreeNode> nodeSet = new HashSet<>();
        nodeSet.add(leafNode);
        while (!bfsQueue.isEmpty()) {
            bfsQueueSize = bfsQueue.size();
            for (int i = 0; i < bfsQueueSize; i++) {
                Pair peekPair = bfsQueue.poll();
                TreeNode peekNode = peekPair.node;
                if (peekPair.distance > distance) break;
                if (isLeaf(peekNode) && peekPair.distance != 0) {
                    answer++;
                }
                if (nodesParentMap.containsKey(peekNode) && !nodeSet.contains(nodesParentMap.get(peekNode))) {
                    nodeSet.add(nodesParentMap.get(peekNode));
                    bfsQueue.add(new Pair(nodesParentMap.get(peekNode), peekPair.distance + 1));
                }
                if (peekNode.left != null && !nodeSet.contains(peekNode.left)) {
                    nodeSet.add(peekNode.left);
                    bfsQueue.add(new Pair(peekNode.left, peekPair.distance + 1));
                }
                if (peekNode.right != null && !nodeSet.contains(peekNode.right)) {
                    nodeSet.add(peekNode.right);
                    bfsQueue.add(new Pair(peekNode.right, peekPair.distance + 1));
                }
            }
        }
    }
    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
