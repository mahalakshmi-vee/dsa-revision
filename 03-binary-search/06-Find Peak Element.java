class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        if (nums[0] > nums[1]) return 0;
        else if (nums[n - 1] > nums[n - 2]) return n - 1;
        int low = 1;
        int high = n - 2;
        int middle = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            if (nums[middle] > nums[middle + 1] && nums[middle] > nums[middle - 1]) return middle;
            else if (nums[middle + 1] > nums[middle]) low = middle + 1;
            else high = middle - 1;
        }
        return -1;
    }
}
// Time complexity: O(LogN)
// Space complexity: O(1)