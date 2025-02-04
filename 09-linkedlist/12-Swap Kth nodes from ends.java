// User function Template for Java
// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public Node swapKthNode(Node head, int k) {
        int nodeCount = getNodeCount(head);
        
        if (k > nodeCount) return head;
        
        Node node1 = head;
        Node node1Previous = null;
        for (int i = 1; i < k; i++) {
            node1Previous = node1;
            node1 = node1.next;
        }
        
        Node node2 = head;
        Node node2Previous = null;
        for (int i = 1; i < (nodeCount - k + 1); i++) {
            node2Previous = node2;
            node2 = node2.next;
        }
        
        if (node1Previous != null) {
            node1Previous.next = node2;
        }
        
        if (node2Previous != null) {
            node2Previous.next = node1;
        }
        
        Node temp = node1.next;
        node1.next = node2.next;
        node2.next = temp;
        
        if (k == 1) head = node2;
        else if (k == nodeCount) head = node1;
        
        return head;
    }
    private int getNodeCount (Node head) {
        int nodeCount = 0;
        Node current = head;
        while (current != null) {
            nodeCount++;
            current = current.next;
        }
        return nodeCount;
    }
}
