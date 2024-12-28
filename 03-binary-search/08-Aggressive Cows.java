class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls); // This function will run NLogN times.
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < stalls.length; i++) high = Math.max(high, stalls[i]); // 'N' number of times this loop will run.
        // Linear search resulted TLE - Time Limit Execeeded.
        // for (int i = high; i >= low; i--) {
        //     if (getAllocatedCows(i, stalls) >= k) return i;
        // }
        // Binary search.
        int middle = 0;
        int answer = 0;
        while (low <= high) { // This loop will run Log(Math.max(stalls[i])) number of times.
            middle = (low + high) / 2;
            if (getAllocatedCows(middle, stalls) >= k) { // The sub function will run 'N' times every time where 'N' represents the length of the stall.
                answer = middle;
                low = middle + 1;
            }
            else high = middle - 1;
        }
        return answer;
    }
    private static int getAllocatedCows(int minDistanceBetweenTwoCows, int[] stalls) {
        int totalCows = 1;
        int lastAllocatedPosition = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastAllocatedPosition >= minDistanceBetweenTwoCows) {
                totalCows++;
                lastAllocatedPosition = stalls[i];
            }
        }
        return totalCows;
    }
}
// Time complexity: O(NLogD), where N is the length of the stalls and D is the difference between the largest and smallest stall positions
// Space complexity: O(1)