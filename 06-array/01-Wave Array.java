class Solution {
    public static void convertToWave(int[] arr) {
        // Time complexity is O(N) and space complexity is O(1).
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n - 1; i += 2) {
            temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }
}
