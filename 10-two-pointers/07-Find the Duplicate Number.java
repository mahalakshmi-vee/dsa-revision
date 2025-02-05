class Solution {
    public int findDuplicate(int[] nums) {
        // Brute Force Approach:
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        // Set<Integer> hashSet = new HashSet<>();
        // for (int i = 0; i < nums.length; i++) {
        //     if (hashSet.contains(nums[i])) return nums[i];
        //     hashSet.add(nums[i]);
        // }
        // return -1;
        // Improved space complexity optimized approch
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        int slow = nums[0];
        int fast = nums[0];
        do {
          slow = nums[slow]; // Moving slow by one step
          fast = nums[nums[fast]];  // Moving fast by two step
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) { // Loop is to identify the starting point of the cycle.
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
