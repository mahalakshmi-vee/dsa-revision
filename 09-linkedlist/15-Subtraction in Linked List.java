
/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

// Time Complexity: O(N + M)
// Space Complexity: O(1)
class Solution {
    static Node subLinkedList(Node head1, Node head2) {
        // Removing the trailing zeros
        while (head1 != null && head1.data == 0) head1 = head1.next;
        while (head2 != null && head2.data == 0) head2 = head2.next;
        
        int head1NodeCount = getNodeCount(head1); 
        int head2NodeCount = getNodeCount(head2);
        
        Node[] biggerSmallerNodes = getBiggerSmallerNodes (head1NodeCount, head1, head2NodeCount, head2);
        Node biggerValueNode = biggerSmallerNodes[0];
        Node smallerValueNode = biggerSmallerNodes[1];
        
        head1 = reverse(biggerValueNode);
        head2 = reverse(smallerValueNode);
        
        // Elementary basic mathematical subtraction.
        Node answerNode = new Node(-1);
        Node answerNodeHead = answerNode;
        int carry = 0;
        int newNodeValue = 0;
        while (head1 != null && head2 != null) {
            newNodeValue = 0;
            head1.data += carry;
            if (head1.data >= head2.data) {
                newNodeValue = head1.data - head2.data;
                carry = 0;
            }
            else {
                newNodeValue = (head1.data + 10) - head2.data;
                carry = -1;
            }
            answerNode.next = new Node(newNodeValue);
            answerNode = answerNode.next;
            head1 = head1.next;
            head2 = head2.next;
        }
        
        while (head1 != null) {
            newNodeValue = 0;
            if (head1.data + carry < 0) {
                newNodeValue = head1.data + 10 + carry;
                carry = -1;
            }
            else {
                newNodeValue = head1.data + carry;
                carry = 0;
            }
            answerNode.next = new Node(newNodeValue);
            answerNode = answerNode.next;
            head1 = head1.next;
        }
        
        // Since head2 is always the smaller value, once the main loop while (head1 != null && head2 != null) 
        // ends, head2 should already be null.
        // Hence no need for while to process based on head2.

        answerNode = reverse(answerNodeHead.next);
        while (answerNode != null && answerNode.data == 0) answerNode = answerNode.next;
        if (answerNode == null) return new Node(0);
        return answerNode;
    }
    private static int getNodeCount (Node node) {
        int nodeCount = 0;
        Node current = node;
        while (current != null) {
            nodeCount++;
            current = current.next;
        }
        return nodeCount;
    }
    private static Node[] getBiggerSmallerNodes (int head1NodeCount, Node head1, int head2NodeCount, Node head2) {
        Node[] biggerSmallerNodes = new Node[2];
        
        Node biggerValueNode = null;
        Node smallerValueNode = null;
        
        if (head1NodeCount > head2NodeCount) {
            biggerValueNode = head1;
            smallerValueNode = head2;
        }
        else if (head2NodeCount > head1NodeCount) {
            biggerValueNode = head2;
            smallerValueNode = head1;
        }
        else {
            Node tempNode1 = head1;
            Node tempNode2 = head2;
            while (tempNode1 != null && tempNode2 != null) {
                if (tempNode1.data > tempNode2.data) {
                    biggerValueNode = tempNode1;
                    smallerValueNode = tempNode2;
                    break;
                }
                else if (tempNode2.data > tempNode1.data) {
                    biggerValueNode = tempNode2;
                    smallerValueNode = tempNode1;
                    break;
                }
                tempNode1 = tempNode1.next;
                tempNode2 = tempNode2.next;
            }
        }
        
        biggerSmallerNodes[0] = biggerValueNode;
        biggerSmallerNodes[1] = smallerValueNode;
        return biggerSmallerNodes;
    }
    private static Node reverse (Node node) {
        Node current = node;
        Node previous = null;
        Node future = null;
        while (current != null) {
            future = current.next;
            current.next = previous;
            previous = current;
            current = future;
        }
        return previous;
    }
}
