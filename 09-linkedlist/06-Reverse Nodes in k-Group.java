/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        ListNode previous = null;
        ListNode newHead = null;
        while (current != null) {
            ListNode kthNode = findKthNode(current, k);
            if (kthNode == null) {
                previous.next = current;
                break;
            }
            ListNode future = kthNode.next;
            kthNode.next = null;
            ListNode reversedKthNode = reverse(current);
            if (newHead == null) {
                newHead = reversedKthNode;
            }
            if (previous != null) {
                previous.next = reversedKthNode;
            }
            previous = current;
            current = future;
        }
        return newHead;
    }
    private ListNode findKthNode (ListNode head, int k) {
        int totalNode = 0;
        ListNode current = head;
        while (current != null) {
            totalNode++;
            if (totalNode == k) break;
            current = current.next;
        }
        return current;
    }
    private ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode future = null;
        while (current != null) {
            future = current.next;
            current.next = previous;
            previous = current;
            current = future;
        }
        return previous;
    }
}
