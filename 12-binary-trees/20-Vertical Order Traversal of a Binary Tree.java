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
    class Pair implements Comparable<Pair> {
        TreeNode node;
        int level;
        int column;
        public Pair(TreeNode node, int level, int column) {
            this.node = node;
            this.level = level;
            this.column = column;
        }
        @Override
        public int compareTo(Pair pair) {
            if (pair.level == this.level) {
                return node.val - pair.node.val;
            }
            return level - pair.level;
        }
    }   
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Pair>> columnMap = new TreeMap<>();
        Queue<Pair> bfsQueue = new LinkedList<>();
        bfsQueue.add(new Pair(root, 0, 0));
        int bfsQueueSize = 0;
        int level = 0;
        while (!bfsQueue.isEmpty()) {
            level++;
            bfsQueueSize = bfsQueue.size();
            for (int i = 0; i < bfsQueueSize; i++) {
                Pair peekPair = bfsQueue.poll();
                TreeNode peekNode = peekPair.node;
                int column = peekPair.column;
                if (columnMap.containsKey(column)) {
                    List<Pair> listPair = columnMap.get(column);
                    listPair.add(peekPair);
                }
                else {
                    List<Pair> listPair = new ArrayList<>();
                    listPair.add(peekPair);
                    columnMap.put(column, listPair);
                }
                if (peekNode.left != null)  bfsQueue.add(new Pair(peekNode.left, level, column - 1));
                if (peekNode.right != null) bfsQueue.add(new Pair(peekNode.right, level, column + 1));
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (List<Pair> val : columnMap.values()) {
            Collections.sort(val);
            List<Integer> nodes = new ArrayList<>();
            for (Pair v : val) {
                nodes.add(v.node.val);
            }
            result.add(nodes);
        }    
        return result;
    }
}
