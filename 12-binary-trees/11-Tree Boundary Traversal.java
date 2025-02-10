// User function Template for Java
/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> listAnswer = new ArrayList<>();
        listAnswer.add(node.data); // Adding root node as it always part of the boundary
        traverseLeft(node.left, listAnswer); // Adding left boundary nodes except leaf nodes
        visitChild(node.left, listAnswer); // Adding all leaf nodes from left subtree
        visitChild(node.right, listAnswer); // Adding all leaf nodes from right subtree
        traverseRight(node.right, listAnswer); // Adding right boundary nodes except leaf nodes
        return listAnswer;
    }
    private static void traverseLeft (Node node, ArrayList<Integer> listAnswer) {
        if (node == null || (node.left == null && node.right == null)) return;
       
        listAnswer.add(node.data);
        
        if (node.left != null) {
            traverseLeft(node.left, listAnswer);
        }
        else if (node.left == null && node.right != null) {
            traverseLeft(node.right, listAnswer);
        }
    }
    private static void traverseRight (Node node, ArrayList<Integer> listAnswer) {
        if (node == null || (node.left == null && node.right == null)) return;
        
        if (node.right != null) {
            traverseRight(node.right, listAnswer);
        }
        else if (node.right == null && node.left != null) {
            traverseRight(node.left, listAnswer);
        }
        
        listAnswer.add(node.data);
    }
    private static void visitChild (Node node, ArrayList<Integer> listAnswer) {
        if (node == null) return;
        else if (node.left == null && node.right == null) {
            listAnswer.add(node.data);
            return;
        }
        
        visitChild(node.left, listAnswer);
        visitChild(node.right, listAnswer);
    }
}
