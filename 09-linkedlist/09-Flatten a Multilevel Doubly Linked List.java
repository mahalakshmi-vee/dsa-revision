/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public Node flatten(Node head) {
        helper(head);
        return head;
    }
    private Node helper (Node head) {
        Node current = head;
        Node lastNode = null;
        Node future = null;
        while (current != null) {
            future = current.next;
            Node child = current.child;
            if (child != null) {
                current.child = null;

                current.next = child;
                child.prev = current;
                
                lastNode = helper(child);
                
                lastNode.next = future;
                if (future != null)
                    future.prev = lastNode;
            }
            else {
                lastNode = current;
            }
            current = future;
        }
        return lastNode;
    }
}
