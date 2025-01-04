class Solution {
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(int arr[]) {
        // Time complexity is O(N) and space complexity is O(N).
        int n = arr.length;
        int[] prefixSumArray = new int[n];
        prefixSumArray[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSumArray[i] = prefixSumArray[i - 1] + arr[i];
        }
        int leftElementsSum = 0;
        int rightElementsSum = 0;
        for (int i = 1; i < n; i++) {
            leftElementsSum = prefixSumArray[i - 1];
            rightElementsSum = prefixSumArray[n - 1] - prefixSumArray[i];
            if (leftElementsSum == rightElementsSum) return i + 1;
        }
        return -1;
    }
}
