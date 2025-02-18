// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    /*class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }*/
    static class Pair {
        Node node;
        Node parentNode;
        public Pair(Node node, Node parentNode) {
            this.node = node;
            this.parentNode = parentNode;
        }
    }

    public static int minTime(Node root, int target) {
        Set<Node> visitedNodeSet = new HashSet<>();
        Node targetNode = null;
        Map<Node, Node> parentNodeMap = new HashMap<>();
        Map<Node, Node> leftChildNodeMap = new HashMap<>();
        Map<Node, Node> rightChildNodeMap = new HashMap<>();
        
        Queue<Pair> bfsQueue = new LinkedList<>();
        bfsQueue.add(new Pair(root, root));
        int bfsQueueSize = 0;
        while (!bfsQueue.isEmpty()) {
            bfsQueueSize = bfsQueue.size();
            for (int i = 0; i < bfsQueueSize; i++) {
                Pair peekPair = bfsQueue.poll();
                Node peekNode = peekPair.node;
                if (peekNode.data == target) targetNode = peekNode;
                parentNodeMap.put(peekNode, peekPair.parentNode);
                
                if (peekNode.left != null) {
                    leftChildNodeMap.put(peekNode, peekNode.left);
                    bfsQueue.add(new Pair(peekNode.left, peekNode));
                }
                if (peekNode.right != null) {
                    rightChildNodeMap.put(peekNode, peekNode.right);
                    bfsQueue.add(new Pair(peekNode.right, peekNode));
                }
            }
        }
        
        int minSecReqToBurnWholeTree = -1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(targetNode);
        while (!queue.isEmpty()) {
            minSecReqToBurnWholeTree++;
            bfsQueueSize = queue.size();
            for (int i = 0; i < bfsQueueSize; i++) {
                Node peekNode = queue.poll();
                visitedNodeSet.add(peekNode);
                
                if (parentNodeMap.containsKey(peekNode)) {
                    Node parentNode = parentNodeMap.get(peekNode);
                    if (!visitedNodeSet.contains(parentNode)) {
                        queue.add(parentNode);
                    }
                }
                if (peekNode.left != null && !visitedNodeSet.contains(peekNode.left)) {
                    queue.add(peekNode.left);
                }
                if (peekNode.right != null && !visitedNodeSet.contains(peekNode.right)) {
                    queue.add(peekNode.right); 
                }
            }
        }
        return minSecReqToBurnWholeTree;
    }
}
