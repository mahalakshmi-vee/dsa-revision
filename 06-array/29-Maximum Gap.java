class Solution {
    public int maximumGap(int[] nums) {
        // Submitted brute force approach:
        // Time complexity is O(NLogN)
        // Space complexity is O(1)
        // Arrays.sort(nums);
        // int answer = 0;
        // int n = nums.length;
        // for (int i = 0; i < n - 1; i++) {
        //     answer = Math.max(answer, nums[i + 1] - nums[i]);
        // }
        // return answer;
        // Optimized Approach:
        // Time complexity: O(N)
        // Space complexity: O(N)
        int n = nums.length;
        if (n <= 1) return 0; // Means no gap.
        int totalGaps = n - 1;
        int maximumElement = Integer.MIN_VALUE;
        int minimumElement = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            maximumElement = Math.max(maximumElement, nums[i]);
            minimumElement = Math.min(minimumElement, nums[i]);
        }

        int totalBucket = totalGaps;
        int bucketSize = (int) Math.ceil((double) (maximumElement - minimumElement) / totalBucket + 1);
        int[] maximumElementBucket = new int[totalBucket];
        int[] minimumElementBucket = new int[totalBucket];
        Arrays.fill(maximumElementBucket, Integer.MIN_VALUE);
        Arrays.fill(minimumElementBucket, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            if (nums[i] == minimumElement) continue;
            int currentElementBucketIndex = (nums[i] - minimumElement) / bucketSize;
            maximumElementBucket[currentElementBucketIndex] = Math.max(nums[i], maximumElementBucket[currentElementBucketIndex]);
            minimumElementBucket[currentElementBucketIndex] = Math.min(nums[i], minimumElementBucket[currentElementBucketIndex]);
        }

        int maximumGap = 0;
        int previousMax = minimumElement;
        for (int i = 0; i < totalBucket; i++) {
            if (minimumElementBucket[i] == Integer.MAX_VALUE) continue;
            maximumGap = Math.max(maximumGap, minimumElementBucket[i] - previousMax);
            previousMax = maximumElementBucket[i];
        }

        return maximumGap;
    }
}
// Example:
// input array = {21, 9, 25, 3, 37, 43, 49, 29}

// Sorted input array = {3, 9, 21, 25, 29, 37, 43, 49} 
// Important point: WE ARE NOT ALLOWED TO DO THE SORTING OPERATION.
// 3-9 Gap is 6
// 21-9 Gap is 12
// 25-21 Gap is 4
// 29-25 Gap is 4
// 37-29 Gap is 8
// 43-37 Gap is 6
// 49-43 Gap is 6
// Maximum gap among all of the above gap is 12. Hence answer is 12.

// Optimized Approach Explanation:

// ** Determine the minimum and maximum values in the array.
// ** Calculate the bucket size and number of buckets.
// ** Distribute the numbers into buckets based on their values.
// ** Find the maximum gap between the maximumValue of one bucket and the minimum value of the next bucket.

// Why total bucket = n - 1 ?
// * If there are 'n' elements in the array, there are exactly n - 1 gaps between consecutive elements.
// * To capture each possible gaps, we create n - 1 buckets. This ensures that:
//     1. Each bucket can potentially hold values that contribute to a single gap.
//     2. If there is a large gap, it spans across buckets, and we calculate it using the maximum of one bucket and the minimum of the next bucket.
    
// Why bucket size = (maximumElement - minimumElement) / totalBucket ?
// * The range of numbers (maximumElement - minimumElement) is divided evenly among the buckets. The bucket size is the width of each bucket.
//     The total range of numbers is (maximumElement - minimumElement)
//     We split this range into n - 1 buckets, so each bucket spans:
//     Bucket Size = (maximumElement - minimumElement) / n - 1.
// * The bucket size ensures that the numbers are spread evenly.
    
// Why currentElementBucketIndex = (nums[i] - minimumElement) / bucketSize ?
// * The bucket index determines where a no. belongs.
// * It measures how far the number is from the minimumElement in terms of bucket width.
//     1. Subtract minimumElement from the current element to measure its distance from the smallest value in the array.
//     2. Divide this distance by the bucket size to calculate how many bucket is spans from the start.
