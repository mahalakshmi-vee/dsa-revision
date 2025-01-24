class Solution {
    public int maxChunksToSorted(int[] arr) {
        // Time complexity is O(N) and space complexity is O(1).
        int count = 0;
        int maxSeen = 0;
        for (int i = 0; i < arr.length; i++) {
            maxSeen = Math.max(maxSeen, arr[i]);
            if (i == maxSeen) count++;
        }
        return count;
    }
}
