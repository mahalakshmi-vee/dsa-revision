/**
 * @param {number[]} nums
 * @return {number}
 */
 // Time Complexity: O(NLogN)
 // Space Complexity: O(1)
var maxProduct = function(nums) {
    nums.sort((a, b) => b - a);
    const num1 = nums[0];
    const num2 = nums[1];
    return (num1 - 1) * (num2 - 1);
};
