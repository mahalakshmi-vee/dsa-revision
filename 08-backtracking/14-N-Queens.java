class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> listAnswer = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = '.';
            }
        }    
        backtrack(board, 0, listAnswer);
        return listAnswer;
    }
    private void backtrack (char[][] board, int rowIndex, List<List<String>> listAnswer) {
        if (rowIndex == board.length) {
            listAnswer.add(constructSolution(board));
            return;
        }
        for (int col = 0; col < board[0].length; col++) {
            if (!isSafe(board, rowIndex, col)) {
                board[rowIndex][col] = 'Q';
                backtrack(board, rowIndex + 1, listAnswer);
                board[rowIndex][col] = '.';
            }
        }
    }
    private List<String> constructSolution(char[][] board) {
        List<String> list = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < board[row].length; col++) {
                sb.append(board[row][col]);
            }
            list.add(sb.toString());
        }
        return list;
    }
    private boolean isSafe(char[][] board, int rowIndex, int colIndex) {
        int n = board.length;

        // Horizontal Checking.
        for (int col = 0; col < n; col++) {
            if (col != colIndex && board[rowIndex][col] == 'Q') return true;
        }
        // Vertical Checking.
        for (int row = 0; row < n; row++) {
            if (row != rowIndex && board[row][colIndex] == 'Q') return true;
        }
        // Upper Left Diagonal Checking.
        for (int row = rowIndex - 1, col = colIndex - 1; row >= 0 && col >= 0; row--, col--) {
            if (board[row][col] == 'Q') return true;
        }
        // Lower Left Diagonal Checking.
        for (int row = rowIndex + 1, col = colIndex - 1; row < n && col >= 0; row++, col--) {
            if (board[row][col] == 'Q') return true;
        }
        // Upper Right Diagonal Checking.
        for (int row = rowIndex - 1, col = colIndex + 1; row >= 0 && col < n; row--, col++) {
            if (board[row][col] == 'Q') return true;
        }
        // Lower Right Diagonal Checking.
        for (int row = rowIndex + 1, col = colIndex + 1; row < n && col < n; row++, col++) {
            if (board[row][col] == 'Q') return true;
        }
        return false;
    }
}
