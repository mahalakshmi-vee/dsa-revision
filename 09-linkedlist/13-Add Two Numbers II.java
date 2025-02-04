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
    // Space Complexity: O(N)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        int sum = 0;
        int carry = 0;
        ListNode answerNode = new ListNode(-1);
        ListNode answerNodeHead = answerNode;
        while (l1 != null || l2 != null) {
            sum = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            if (sum > 9) {
                answerNode.next = new ListNode(sum % 10);
                carry = sum / 10;
            }
            else {
                answerNode.next = new ListNode(sum);
                carry = 0;
            }
            answerNode = answerNode.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }   
        if (carry != 0) {
            answerNode.next = new ListNode(carry);
        }
        return reverse(answerNodeHead.next);
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
