class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int middle = 0;

        int[] answerArray = new int[2];
        answerArray[0] = -1;
        answerArray[1] = -1;

        while (low <= high) {
            middle = (low + high) / 2;
            if (nums[middle] == target) {
                answerArray[0] = middle;
                high = middle - 1;
            }
            else if (nums[middle] < target) low = middle + 1;
            else high = middle - 1;
        }

        low = 0;
        high = nums.length - 1;

        while (low <= high) {
            middle = (low + high) / 2;
            if (nums[middle] == target) {
                answerArray[1] = middle;
                low = middle + 1;
            }
            else if (nums[middle] < target) low = middle + 1;
            else high = middle - 1;
        }

        return answerArray;
    }
}
// Time complexity: O(Log N)
// Space complexity: O(1)