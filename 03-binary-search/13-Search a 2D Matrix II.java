class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix[0].length - 1;
        while (low < matrix.length && high >= 0) {
            if (matrix[low][high] == target) return true;
            else if (matrix[low][high] > target) high = high - 1;
            else low = low + 1;    
        }
        return false;
    }
}
// Time complexity: O(M + N)
// Space complexity: O(1)