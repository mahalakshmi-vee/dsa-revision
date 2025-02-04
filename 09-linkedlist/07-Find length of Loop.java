
/*

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

// Function should return the length of the loop in LL.

class Solution {
    // Function to find the length of a loop in the linked list.
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int countNodesinLoop(Node head) {
        if (head == null || head.next == null) return 0;
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (slow != fast) return 0;
        int length = 0;
        do {
            length++;
            slow = slow.next;
        }while(slow != fast);
        return length;
    }
}
