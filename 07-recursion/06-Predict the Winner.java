class Solution {
    public boolean predictTheWinner(int[] nums) {
        return findScore (nums, 0, nums.length - 1) >= 0;
    }
    private int findScore (int[] nums, int start, int end) {
        if (start == end) return nums[start];

        int scoreLeft = nums[start] - findScore(nums, start + 1, end);
        int scoreRight = nums[end] - findScore(nums, start, end - 1);

        return Math.max(scoreLeft, scoreRight);
    }
}

// Example:
// 1, 5, 2
// If player1 chooses 1 (5, 2) => player2 will choose 5 (he focus on optimal result) => 1 - 5 = -4 < 0 so player1 lose the game
// If player1 chooses 2 (1, 5) => player2 will choose 5 (he focus on optimal result) => 2 - 5 = -3 < 0 so player1 lose the game


// Time Complexity: O(2 ^ n)
// Space Complexity: O(N)
