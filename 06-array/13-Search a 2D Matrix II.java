class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int high = matrix[0].length - 1;
        int low = 0;
        int middle = 0;
        while (low < matrix.length && high >= 0) {
            if (matrix[low][high] == target) return true;
            else if (matrix[low][high] > target) high--;
            else low++;
        }
        return false;
    }
}
// Time complexity is O(M + N) and space complexity is O(1).
