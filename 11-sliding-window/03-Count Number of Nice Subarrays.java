class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // Brute force approach:
        // Time Complexity: O(N ^ 2)
        // Space Complexity: O(1)
        // int answer = 0;
        // int oddNumberCount = 0;
        // int n = nums.length;
        // for (int i = 0; i < n; i++) {
        //     oddNumberCount = 0;
        //     for (int j = i; j < n; j++) {
        //         if (nums[j] % 2 != 0) oddNumberCount++;
        //         if (oddNumberCount == k) answer++;
        //     }
        // }
        // return answer;
        // Optimized approach - Using Sliding Window.
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        return countSubarraysWithAtMostKOdd(nums, k) - countSubarraysWithAtMostKOdd(nums, k - 1);
    }
    private int countSubarraysWithAtMostKOdd(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        int leftPointer = 0;
        int rightPointer = 0;
        int answer = 0;
        while (rightPointer < n) {
            if (nums[rightPointer] % 2 != 0) count++;
            while (leftPointer <= rightPointer && count > k) {
                if (nums[leftPointer] % 2 != 0) count--;
                leftPointer++;
            }
            rightPointer++;
            answer += (rightPointer - leftPointer + 1);
        }
        return answer;
    }
}
