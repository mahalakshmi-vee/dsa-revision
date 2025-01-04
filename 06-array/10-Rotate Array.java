class Solution {
    public void rotate(int[] nums, int k) {
        // Time complexity is O(N) and space complexity is O(1).
        int n = nums.length;
        if (k > n) k = k % n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }
    private void reverse  (int[] nums, int left, int right) {
        int temp = 0;
        while (left < right) {
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
