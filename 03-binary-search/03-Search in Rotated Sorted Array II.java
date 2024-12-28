class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int middle = 0;

        while (low <= high) {
            middle =(low + high) / 2;
            if (nums[middle] == target) return true;
            else if (nums[low] == nums[middle] && nums[middle] == nums[high]) {
                low++;
                high--;
            }
            else if (nums[low] <= nums[middle]) { // Left part of middle is obviously fully in sorted order.
                if (nums[low] <= target && nums[middle] >= target) high = middle - 1;
                else low = middle + 1;
            }
            else { // Right part of middle is obviously fully in sorted order.
                if (nums[middle] <= target && nums[high] >= target) low = middle + 1;
                else high = middle - 1;
            }
        }

        return false;
    }
}
// Time complexity: O(LogN) for average (big-theta) and base case (big-omega). O(N) for worst case (big-oh).
// Space complexity: O(1)