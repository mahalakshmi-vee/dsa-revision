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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int totalNode = 0;
        ListNode current = head;
        while (current != null) {
            totalNode++;
            current = current.next;
        }
        int removeNodeIndex = totalNode - n + 1;
        if (removeNodeIndex == 1) return head.next;
        totalNode = 0;
        current = head;
        ListNode previous = null;
        while (current != null) {
            totalNode++;
            if (totalNode == removeNodeIndex) {
                previous.next = current.next;
                break;
            }
            previous = current;
            current = current.next;
        }
        return head;
    }
}
