class Solution {
    public int TotalPairs(int[] nums, int k) {
        // Brute force approach: Check all pairs - Got TLE.
        // Time Complexity: O(N ^ 2)
        // Space Complexity: O(N)
        // int n = nums.length;
        // int answer = 0;
        // Set<List<Integer>> pairSet = new HashSet<>(); // To keep the unique pairs.
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         List<Integer> listPair = new ArrayList<>();
        //         listPair.add(nums[i]);
        //         listPair.add(nums[j]);
        //         Collections.sort(listPair);
        //         pairSet.add(listPair);
        //     }
        // }
        // for (List<Integer> pair : pairSet) { // checking all the unique pairs to find the answer.
        //     if (Math.abs(pair.get(0) - pair.get(1)) == k) answer++;
        // }
        // return answer;
        // Optimized approach:
        // Time Complexity: O(NLogN)
        // Space Complexity: O(1)
        Arrays.sort(nums);
        int leftPointer = 0;
        int rightPointer = 1;
        int n = nums.length;
        int answer = 0;
        int diff = 0;
        while (rightPointer < n) {
            diff = nums[rightPointer] - nums[leftPointer];
            if (diff < k) rightPointer++;
            else if (diff > k) leftPointer++;
            else {
                if (leftPointer < rightPointer)
                    answer++;
                int temp = rightPointer;
                while (temp < n && nums[temp] ==nums[rightPointer]) temp++;
                rightPointer = temp;
            }
        }
        return answer;
    }
}
