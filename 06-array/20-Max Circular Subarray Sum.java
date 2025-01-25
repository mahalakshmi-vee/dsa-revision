class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {
        int totalSum = 0;
        
        int currentMax = 0;
        int maxSum = Integer.MIN_VALUE;
        
        int currentMin = 0;
        int minSum = Integer.MAX_VALUE;
        
        for (int el : arr) {
            totalSum += el;
            
            currentMax = Math.max(currentMax + el, el);
            maxSum = Math.max(maxSum, currentMax);
            
            currentMin = Math.min(currentMin + el, el);
            minSum = Math.min(minSum, currentMin);
        }
        
        // Handle the case where all the elements are negative.
        if (maxSum < 0) {
            return maxSum; // Maximum is the largest single element.
        }
        
        // Return the maximum of non-circular and circular cases.
        return Math.max(maxSum, totalSum - minSum);
    }
}

// Time complexity is O(N) and space complexity is O(1).

// Explanation:
// Since the array is circular, the maximum subarray sum may span 
// the end of the array and wrap to the beginning. 
// To handle this, we calculate the total sum of the array and subtract 
// the minimum subarray sum to determine the circular maximum subarray sum.
//
// Example:
// Consider a circular array [el1, el2, el3, el4].
// The maximum subarray sum might span from [el4, el1, el2, el3].
// In this case, subtracting el2 (minimum subarray) from the total sum 
// gives the circular maximum subarray sum.
