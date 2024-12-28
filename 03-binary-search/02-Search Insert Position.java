class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int middle = 0;
        int answer = nums.length;
        while (low <= high) {
            middle = (low + high) / 2;
            if (nums[middle] == target) return middle;
            else if (nums[middle] < target) low = middle + 1;
            else {
                high = middle - 1;
                answer = middle;
            }
        }
        return answer;
    }
}
// Time complexity: O(LogN)
// Space complexity: O(1)