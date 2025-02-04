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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Time Complexity: O(NLogN)
    // Space Complexity: O(LogN)
    // Where N represents the total number of nodes in the given linked list
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        else if (head.next == null) return new TreeNode(head.val);

        ListNode[] subAnswer = findMiddleNode(head);
        ListNode middleNode = subAnswer[0];
        ListNode middlePreviousNode = subAnswer[1];
        if (middlePreviousNode != null)
            middlePreviousNode.next = null;
        TreeNode root = new TreeNode(middleNode.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(middleNode.next);
        return root;
    }
    private ListNode[] findMiddleNode (ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode previous = null;
        while (fast.next != null && fast.next.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode[] answer = new ListNode[2];
        if (fast.next == null) {
            answer[0] = slow;
            answer[1] = previous;
            return answer;
        }
        answer[0] = slow.next;
        answer[1] = slow;
        return answer;
    }
}
// Time Complexity Analysis:
// Since the recursion depth is O(Log N) and each level does O(N) work, the total time complexity is:
// O(N) + O(N) + O(N) +.....(LogN times) = O(N Log N).
    //            N   (Find Middle → O(N))
    //          /   \
    //     N/2       N/2   (Find Middle → O(N/2) + O(N/2))
    //    /   \      /   \
    //  N/4   N/4  N/4   N/4   (Each Find Middle → O(N/4))
    //  ...    ...   ...   ...
