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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        ListNode previous = null;
        ListNode newHead = null;
        while (current != null) {
            ListNode kThNode = findKThNode(current, k);
            if (kThNode == null) {
                previous.next = current;
                break;
            }
            ListNode kThNodeNext = kThNode.next;
            kThNode.next = null;
            ListNode reversedNode = reverse(current);
            if (newHead == null) newHead = reversedNode;
            if (previous != null)
                previous.next = reversedNode;
            previous = current;
            current = kThNodeNext;
        }
        return newHead;
    }
    private ListNode findKThNode (ListNode head, int k) {
        int totalNode = 0;
        ListNode current = head;
        while (current != null) {
            totalNode++;
            if (totalNode == k) return current;
            current = current.next;
        }
        return null;
    }
    private ListNode reverse (ListNode head) {
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
