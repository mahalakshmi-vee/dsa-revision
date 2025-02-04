/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node current = head;
        while (current != null) {
            Node future = current.next;
            Node newNode = new Node(current.val);
            current.next = newNode;
            newNode.next = future;
            current = future;
        }
        current = head;
        while (current != null) {
            if (current.random != null)
                current.next.random = current.random.next;
            current = current.next.next;
        }
        current = head;
        Node deepCopyHead = current.next;
        while (current != null) {
            Node newNode = current.next;
            Node future = newNode.next;
            current.next = newNode.next;
            if (current.next != null)
                newNode.next = current.next.next;
            current = future;
        }
        return deepCopyHead;
    }
}
