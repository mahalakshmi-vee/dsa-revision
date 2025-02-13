// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

// Time Complexity: O(N)
// Space Complexity: O(N)

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {
    int findDist(Node root, int a, int b) {
        Node lcaNode = lca(root, a, b);
        int lcaNodeLevel = 0;
        int answer = 0;
        
        Queue<Node> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        int bfsQueueSize = 0;
        int level = 0;
        while (!bfsQueue.isEmpty()) {
            level++;
            bfsQueueSize = bfsQueue.size();
            for (int i = 0; i < bfsQueueSize; i++) {
                Node peekNode = bfsQueue.poll();
                if (peekNode == lcaNode) {
                    lcaNodeLevel = level;
                }
                else if (peekNode.data == a || peekNode.data == b) {
                    answer += (level - lcaNodeLevel);
                }
                if (peekNode.left != null) bfsQueue.add(peekNode.left);
                if (peekNode.right != null) bfsQueue.add(peekNode.right);
            }
        }
        
        return answer;
    }
    private static Node lca (Node root, int a, int b) {
        if (root == null) return root;
        else if (root.data == a || root.data == b) return root;
        
        Node lst = lca(root.left, a, b);
        Node rst = lca(root.right, a, b);
        
        if (lst != null && rst != null) return root;
        
        return lst == null ? rst : lst;
    }
}
