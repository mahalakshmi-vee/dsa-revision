class Solution {
    // Function for finding maximum and value pair
    int minSwap(int[] arr, int k) {
        // Sliding Window technique.
        // Time complexity is O(N) and space complexity is O(1).
        int windowSize = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) windowSize++;
        }
        int totalWindow = n - windowSize;
        int swapCountRequired = 0;
        int minSwap = Integer.MAX_VALUE;
        for (int i = 0; i < windowSize; i++) {
            if (arr[i] > k) swapCountRequired++;
        }
        minSwap = Math.min(minSwap, swapCountRequired);
        int inElement = 0;
        int outElement = 0;
        for (int i = 1; i <= totalWindow; i++) {
            outElement = arr[i - 1];
            inElement = arr[i + windowSize - 1];
            if (outElement > k) swapCountRequired--;
            if (inElement > k) swapCountRequired++;
            minSwap = Math.min(minSwap, swapCountRequired);
        }
        return  minSwap;
    }
}
