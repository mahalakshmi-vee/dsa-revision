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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int totalNode = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            totalNode++;
        }
        int removeNodeIndex = totalNode - n;
        current = head;
        ListNode previous = null;
        totalNode = 0;
        if (removeNodeIndex == 0) return head.next;
        while (current != null) {
            if (totalNode == removeNodeIndex) {
                if (previous != null)
                    previous.next = current.next;
                break;
            }
            totalNode++;
            previous = current;
            current = current.next;
        }
        return head;
    }
}
