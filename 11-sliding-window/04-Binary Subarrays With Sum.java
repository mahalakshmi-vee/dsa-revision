class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // int answer = 0;
        // int n = nums.length;
        // int sum = 0;
        // for (int i = 0; i < n; i++) {
        //     sum = 0;
        //     for (int j = i; j < n; j++) {
        //         sum += nums[j];
        //         if (sum == goal) answer++;
        //     }
        // }
        // return answer;
        // Optimized approach:
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        return countSubarraysAtMostGoal(nums, goal) - countSubarraysAtMostGoal(nums, goal - 1);
    }
    private int countSubarraysAtMostGoal(int[] nums, int goal) {
        int answer = 0;
        int sum = 0;
        int n = nums.length;
        int leftPointer = 0;
        int rightPointer = 0;
        while (rightPointer < n) {
            sum += nums[rightPointer];
            while (sum > goal && leftPointer <= rightPointer) {
                sum -= nums[leftPointer];
                leftPointer++;
            }
            rightPointer++;
            answer += (rightPointer - leftPointer + 1);
        }
        return answer;
    }
}

// A valid subarray might have multiple valid subarrays inside of it. To count the exact number of valid subarrays, we use the difference between 
// the counts of subarrays with at most goal and at most goal - 1.

// If I am asked to return the maximum size subarray, then I can run a single loop with the sliding window approach to find the answer.
