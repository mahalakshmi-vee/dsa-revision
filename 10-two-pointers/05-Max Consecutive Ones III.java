// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int rightPointer = 0;
        int leftPointer = 0;
        int zerosCount = 0;
        int answer = 0;
        while (rightPointer < n) {
            if (nums[rightPointer] == 1) {
                while (rightPointer < n && nums[rightPointer] == 1) rightPointer++;
            }
            else {
                zerosCount++;
                while (leftPointer <= rightPointer && zerosCount > k) {
                    if (nums[leftPointer] == 0) zerosCount--;
                    leftPointer++;
                }
                rightPointer++;
            } 
            answer = Math.max(answer, rightPointer - leftPointer);
        }
        return answer;
    }
}
