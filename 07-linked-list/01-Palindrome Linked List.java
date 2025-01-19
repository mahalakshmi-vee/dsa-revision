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
    public boolean isPalindrome(ListNode head) {
        ListNode middleNode = findMiddleNode (head);
        ListNode middleNodeNext = middleNode != null ? middleNode.next : null;
        if (middleNode != null)
            middleNode.next = null;
        ListNode reversedMiddleNext = reverse(middleNodeNext);
        ListNode nodeA = head;
        ListNode nodeB = reversedMiddleNext;
        while (nodeA != null && nodeB != null) {
            if (nodeA.val != nodeB.val) return false;
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return true;
    }
    private ListNode findMiddleNode (ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
