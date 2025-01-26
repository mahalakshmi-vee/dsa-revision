// class Solution {
    // public int maximumGap(int[] nums) {
        // Submitted brute force approach:
        // Time complexity is O(NLogN)
        // Space complexity is O(1)
        // Arrays.sort(nums);
        // int answer = 0;
        // int n = nums.length;
        // for (int i = 0; i < n - 1; i++) {
        //     answer = Math.max(answer, nums[i + 1] - nums[i]);
        // }
        // return answer;
    // }
// // }
// Example:
// input array = {21, 9, 25, 3, 37, 43, 49, 29}

// Sorted input array = {3, 9, 21, 25, 29, 37, 43, 49} 
// Important point: WE ARE NOT ALLOWED TO DO THE SORTING OPERATION.
// 3-9 Gap is 6
// 21-9 Gap is 12
// 25-21 Gap is 4
// 29-25 Gap is 4
// 37-29 Gap is 8
// 43-37 Gap is 6
// 49-43 Gap is 6
// Maximum gap among all of the above gap is 12. Hence answer is 12.
