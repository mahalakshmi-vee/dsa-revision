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
    // Time Complexity: O(N Log K)
    // Sapce Complexity: O(Log K)
    // K represents the length of the lists array.
    // N represents the total number of nodes across all linked lists in the lists array. 
    public ListNode mergeKLists(ListNode[] lists) {
        
        return mergeSort(lists, 0, lists.length - 1);
    }
    private ListNode mergeSort(ListNode[] lists, int start, int end) {
        if (start > end) return null;
        else if (start == end) return lists[start];
        int middle = (start + end) / 2;
        ListNode nodeA = mergeSort(lists, start, middle);
        ListNode nodeB = mergeSort(lists, middle + 1, end);
        return merge(nodeA, nodeB);
    }
    private ListNode merge (ListNode nodeA, ListNode nodeB) {
        ListNode dummyNode = new ListNode(-1);
        ListNode dummyNodeHead = dummyNode;
        while (nodeA != null && nodeB != null) {
            if (nodeA.val < nodeB.val) {
                dummyNode.next = nodeA;
                nodeA = nodeA.next;
            }
            else {
                dummyNode.next = nodeB;
                nodeB = nodeB.next;
            }
            dummyNode =dummyNode.next;
        }
        while (nodeA != null) {
            dummyNode.next = nodeA;
            nodeA = nodeA.next;
            dummyNode = dummyNode.next;
        }
        while (nodeB != null) {
            dummyNode.next = nodeB;
            nodeB = nodeB.next;
            dummyNode = dummyNode.next;
        }
        return dummyNodeHead.next;
    }
}
