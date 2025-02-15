/* class Node
class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}*/

//This function should return head to the DLL
// Time Complexity: O(N)
// Space Complexity: O(N) (recursive call stack)
class Solution
{
    private Node previousNode = null;
    private Node resultNode = null;
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
	    inorder(root);
	    return resultNode;
    }
    private void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        if (previousNode == null) resultNode = root;
        else {
            previousNode.right = root;
            root.left = previousNode;
        }
        previousNode = root;
        inorder(root.right);
    }
}
