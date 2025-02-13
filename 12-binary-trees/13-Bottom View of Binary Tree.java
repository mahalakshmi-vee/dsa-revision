// Time Complexity: O(N Log N) (due to treeMap implementation)
// Space Complexity: O(N)
class Solution
{
    static class Pair {
        Node node;
        int column;
        public Pair(Node node, int column) {
            this.node = node;
            this.column = column;
        }
    }
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        Map<Integer, Integer> columnMap = new TreeMap<>();
        Queue<Pair> bfsQueue = new LinkedList<>();
        bfsQueue.add(new Pair(root, 0));
        int bfsQueueSize = 0;
        while (!bfsQueue.isEmpty()) {
            bfsQueueSize = bfsQueue.size();
            for (int i = 0; i < bfsQueueSize; i++) {
                Pair peekPair = bfsQueue.poll();
                Node peekNode = peekPair.node;
                int column = peekPair.column;
                columnMap.put(column, peekNode.data);
                if (peekNode.left != null) bfsQueue.add(new Pair(peekNode.left, column - 1));
                if (peekNode.right != null) bfsQueue.add(new Pair(peekNode.right, column + 1));
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : columnMap.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
