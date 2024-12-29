class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // Brute force approach - O(N * N) time complexity and O(N * N) space complexity.
        // List<Integer> listElement = new ArrayList<>();
        // for (int row = 0; row < matrix.length; row++) {
        //     for (int col = 0; col < matrix[row].length; col++) {
        //         listElement.add(matrix[row][col]);
        //     }
        // }
        // Collections.sort(listElement);
        // return listElement.get(k - 1);
        // Brute force approach - O(N * N * LogK) time complexity and O(K) space complexity.
        // Queue<Integer> maxHeap = new PriorityQueue<>((a, b)-> b - a);
        // for (int row = 0; row < matrix.length; row++) {
        //     for (int col = 0; col < matrix[row].length; col++) {
        //         if (maxHeap.size() < k) {
        //             maxHeap.add(matrix[row][col]);
        //         }
        //         else {
        //             if (maxHeap.peek() > matrix[row][col]) {
        //                 maxHeap.poll();
        //                 maxHeap.add(matrix[row][col]);
        //             }
        //         }
        //     }
        // }
        // return maxHeap.peek();
        // Log(low-high) * (n + n) where n represents the length of the square matrix.
        // low represents the first element of the matrix
        // high represents the last element of the matrix.
        // Time complexity: O(N * Log(low - high))
        // Space complexity: O(1)
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];
        int middle = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            
            int i = 0, j = n - 1, count = 0;
            while (i < n && j >= 0) {
                if (matrix[i][j] > middle) j--;
                else {
                    count += (j + 1);
                    i++;
                }
            }

            if (count < k) low = middle + 1;
            else {
                high = middle - 1;
            }
        }
        return low;
    }
}