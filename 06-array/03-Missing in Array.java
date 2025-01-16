class Solution {
    int missingNumber(int arr[]) {
        // Submitted brute force approach. Time complexity is O(N) and space complexity is O(1).
        int n = arr.length;
        // Set<Integer> hashSet = new HashSet<>();
        // for (int i = 0; i < n; i++) hashSet.add(arr[i]);
        // for (int i = 1; i <= n; i++) {
        //     if (!hashSet.contains(i)) return i;
        // }
        // Optimized approach. Time complexity is O(N) and space complexity is O(1).
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == i + 1) continue;
            while (arr[i] < n && arr[i] != i + 1) {
                temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) return i + 1;
        }   
        return n + 1;
    }
}