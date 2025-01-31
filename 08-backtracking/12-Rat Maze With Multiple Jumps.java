class Solution
{
    public int[][] ShortestDistance(int[][] matrix)
    {
        int[][] answerMatrix = new int[matrix.length][matrix[0].length];
        if (!ratmaze(matrix, answerMatrix, 0, 0)) return new int[][]{{-1}};
        return answerMatrix;
    }
    private boolean ratmaze(int[][] matrix, int[][] answerMatrix, int row, int col) {
        if (row == matrix.length - 1 && col == answerMatrix[row].length - 1) {
            answerMatrix[row][col] = 1;
            return true;
        }
        
        if (winthinBoundary(row, col, matrix)) {
            answerMatrix[row][col] = 1;
            for (int noofsteps =1; noofsteps <= matrix[row][col]; noofsteps++) {
                if (ratmaze(matrix, answerMatrix, row, col + noofsteps)) return true;
                if (ratmaze(matrix, answerMatrix, row + noofsteps, col)) return true;
            }
            answerMatrix[row][col] = 0;
        }
        return false;
    }
    private boolean winthinBoundary (int row, int col, int[][] matrix) {
        
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length && matrix[row][col] != 0;
    }
}



// Time Complexity Analysis:

// * The function ratmaze(matrix, answerMatrix, row, col) is called for each cell.
// * At each cell (row, col); the rat can jump right or down.
// * The number of recursive calls depends on the value of matrix[row][col], which determines how many steps we can jump.
// Worst Case Scenario:
// * Suppose matrix[row][col] = k (some large value), then from that cell, we can make upto 2k recursive calls.
// * If we assume that at each step, we have at most 2 choices (jump right or jump down), then the number of paths grows exponentially.

// Worst Case Time Complexity:
// * If the matrix is of size N * N the recursion call could explore almost every possible paths.
// * The worst case is when every cell has a high number, leading to multiple branching at each step.
// * The total number of states in the recursive tree can be approximated by:
// O(2 ^ (N ^ 2)).
// This happens because:
// * Every cell can generate upto 2 choices.
// * The depth of recursion could grow upto (N ^ 2).

// Since there are atmost (N ^ 2) cells and each cell can have upto 2 choices, the worst case results in exponential number of calls.

// Final Worst Case Time Complexity: O(2 ^ (N ^ 2))

// Space Complexity: O(N ^ 2)


// Rat in a Maze Problem - I
// class Solution {
//     // Function to find all possible paths
//     public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
//         ArrayList<String> listAnswer = new ArrayList<>();
//         boolean[][] visited = new boolean[mat.size()][mat.get(0).size()];
//         ratmaze(mat, listAnswer, new StringBuilder(), 0, 0, visited);
//         Collections.sort(listAnswer);
//         return listAnswer;
//     }
//     private boolean ratmaze(ArrayList<ArrayList<Integer>> mat, ArrayList<String> listAnswer, StringBuilder sb, int row, int col, boolean[][] visited) {
//         if (row == mat.size() - 1 && col == mat.get(0).size() - 1) {
//             listAnswer.add(sb.toString());
//             return true;
//         }
//         visited[row][col] = true;
//         if (withinBoundary(mat, row - 1, col, visited)) {
//             sb.append("U");
//             ratmaze(mat, listAnswer, sb, row - 1, col, visited);
//             sb.deleteCharAt(sb.length() - 1);
//         }
//         if (withinBoundary(mat, row + 1, col, visited)) {
//             sb.append("D");
//             ratmaze(mat, listAnswer, sb, row + 1, col, visited);
//             sb.deleteCharAt(sb.length() - 1);
//         }
//         if (withinBoundary(mat, row, col - 1, visited)) {
//             sb.append("L");
//             ratmaze(mat, listAnswer, sb, row, col - 1, visited);
//             sb.deleteCharAt(sb.length() - 1);
//         }
//         if (withinBoundary(mat, row, col + 1, visited)) {
//             sb.append("R");
//             ratmaze(mat, listAnswer, sb, row, col + 1, visited);
//             sb.deleteCharAt(sb.length() - 1);
//         }
//         visited[row][col] = false;
//         return false;
//     }
//     private boolean withinBoundary (ArrayList<ArrayList<Integer>> mat, int row, int col, boolean[][] visited) {
        
//         return row >= 0 && col >= 0 && row < mat.size() && col < mat.get(0).size() && mat.get(row).get(col) != 0 && !visited[row][col];
//     }
// }
