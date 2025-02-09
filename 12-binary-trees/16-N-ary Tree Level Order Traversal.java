/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> listAnswer = new ArrayList<>();
        if (root == null) return listAnswer;
        Queue<Node> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        int bfsQueueSize = 0;
        while (!bfsQueue.isEmpty()) {
            bfsQueueSize = bfsQueue.size();
            List<Integer> listSubAnswer = new ArrayList<>();
            for (int i = 0; i < bfsQueueSize; i++) {
                Node peekNode = bfsQueue.poll();    
                listSubAnswer.add(peekNode.val);
                if (peekNode.children == null) continue;
                for (Node child : peekNode.children) {  
                    if (child != null) bfsQueue.add(child);
                }
            }
            listAnswer.add(listSubAnswer);
        }
        return listAnswer;
    }
}
