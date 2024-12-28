class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;
        int middle = 0;
        int searchRowIndex = -1;

        while (low <= high) {
            middle = (low + high) / 2;
            if (matrix[middle][0] <= target) {
                searchRowIndex = middle;
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }

        if (searchRowIndex == -1) return false;

        low = 0;
        high = matrix[0].length - 1;
        while (low <= high) {
            middle = (low + high) / 2;
            if (matrix[searchRowIndex][middle] == target) return true;
            else if (matrix[searchRowIndex][middle] < target) low = middle + 1;
            else high = middle - 1;
        }

        return false;
    }
}
// Time complexity: O(LogMN)
// Space complexity: O(1)