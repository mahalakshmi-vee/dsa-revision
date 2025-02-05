// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
  public int countPairs (int[] nums, int target) {
        int n = nums.length;
        int leftPointer = 0;
        int rightPointer = n - 1;
        int sum = 0;
        int answer = 0;
        while (leftPointer < rightPointer) {
        	sum = nums[leftPointer] + nums[rightPointer];
        	if (sum < target) leftPointer++;
        	else if (sum > target) rightPointer--;
        	else {
        		if (nums[rightPointer] == nums[leftPointer]) {
        			int count = rightPointer - leftPointer + 1;
        			answer += ((count * (count - 1)) / 2);
        			break;
        		}
        		int leftCount = 0;
        		int rightCount = 0;
        		int leftElement = nums[leftPointer];
        		while (leftPointer < rightPointer && nums[leftPointer] == leftElement) {
        			leftCount++;
        			leftPointer++;
        		}
        		int rightElement = nums[rightPointer];
        		while (leftPointer < rightPointer && nums[rightPointer] == rightElement) {
        			rightCount++;
        			rightPointer--;
        		}
        		answer += (leftCount * rightCount);
        	}
        }
        return answer;
  }
}
