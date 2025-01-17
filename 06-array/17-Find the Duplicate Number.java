class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        // Brute force approach: Time complexity is O(NLogN) and Space complexity is O(N).
        // Arrays.sort(nums);
        // for (int i = 0; i < n - 1; i++) {
        //     if (nums[i] == nums[i + 1]) return nums[i];
        // }
        // Optimized approach: Time complexity is O(N) and space complexity is O(N).
        // Set<Integer> hashSet = new HashSet<>();
        // for (int i = 0; i < n; i++) {
        //     if (hashSet.contains(nums[i])) return nums[i];
        //     hashSet.add(nums[i]);
        // }
        // Floyd's cycle detection algorithm. Time complexity is O(N) and space complexity is O(1).
        int slow = 0;
        int fast = 0;
        do {    
           slow = nums[slow];
           fast = nums[nums[fast]];
        }while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
