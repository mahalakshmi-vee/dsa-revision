class Solution {
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int maxArea(int[] height) {
        int wt = 0;
        int ht = 0;
        int area = 0;
        int maxArea = 0;
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        while (leftPointer < rightPointer) {
            wt = rightPointer - leftPointer;
            ht = Math.min(height[leftPointer], height[rightPointer]);
            area = wt * ht;
            maxArea = Math.max(maxArea, area);
            if (height[rightPointer] > height[leftPointer]) leftPointer++;
            else rightPointer--;
        }
        return maxArea;
    }
}
