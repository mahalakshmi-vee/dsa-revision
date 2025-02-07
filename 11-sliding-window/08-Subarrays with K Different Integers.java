class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // Brute force approach: Got Time Limit Exceeded exception.
        // Time Complexity: O(N ^ 2)
        // Space Complexity: O(N)
        // int n = nums.length;
        // int answer = 0;
        // for (int i = 0; i < n; i++) {
        //     Set<Integer> hashSet = new HashSet<>();
        //     for (int j = i; j < n; j++) {
        //         hashSet.add(nums[j]);
        //         if (hashSet.size() == k) answer++;
        //     }
        // }
        // return answer;
        // Optimized approach:
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        return countSubarraysWithAtMostK(k, nums) - countSubarraysWithAtMostK(k - 1, nums);
    }
    private int countSubarraysWithAtMostK(int k, int[] nums) {
        if (k == 0) return 0;
        int count = 0;
        int leftPointer = 0;
        int rightPointer = 0;
        int n = nums.length;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        while (rightPointer < n) {
            frequencyMap.put(nums[rightPointer], frequencyMap.getOrDefault(nums[rightPointer] , 0) + 1);
            while (leftPointer < rightPointer && frequencyMap.size() > k) {
                frequencyMap.put(nums[leftPointer], frequencyMap.get(nums[leftPointer]) - 1);
                if (frequencyMap.get(nums[leftPointer]) == 0) frequencyMap.remove(nums[leftPointer]);
                leftPointer++;
            }
            count += (rightPointer - leftPointer + 1);
            rightPointer++;
        }
        return count;
    }
}
