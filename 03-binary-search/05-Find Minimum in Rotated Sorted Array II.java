class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int middle = 0;

        while (low < high) {
            middle = (low + high) / 2;
            if (nums[low] == nums[middle] && nums[middle] == nums[high]) {
                low++;
                high--;
            }
            else if (nums[middle] <= nums[high]) { 
                high = middle;
            }
            else { 
                low = middle + 1;
            }
        }

        return nums[high];
    }
}
// Time complexity: O(LogN) for average (big-theta) and best case (big-omega). O(N) for worst case (big-oh).
// Space complexity: O(1)