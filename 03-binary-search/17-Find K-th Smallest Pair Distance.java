class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        // Brute force approach: Time complexity is O(N^2) and space complexity is O(N ^ 2).
        // List<Integer> listAnswer = new ArrayList<>();
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         listAnswer.add(Math.abs(nums[j] - nums[i]));
        //     }
        // }
        // Collections.sort(listAnswer);
        // return listAnswer.get(k - 1);
        // Efficient approach: Time complexity is O(NLogN) and space complexity is O(N).
        Arrays.sort(nums);
        int low = 0;
        int high = nums[n - 1] - nums[0];
        int middle = 0;
        int totalPairWithDistanceLessThanOrEqualK = 0;
        while (low < high) {
            middle = (low + high) / 2;
            totalPairWithDistanceLessThanOrEqualK = helperFn(nums, middle);
            if (totalPairWithDistanceLessThanOrEqualK < k) low = middle + 1;
            else high = middle;
        }
        return high;
    }
    private int helperFn (int[] nums, int middle) {
        int count = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[j] - nums[i] <= middle) count++;
        //     }
        // }
        int p2 = 0;
        int p1 = 0;
        while (p2 < nums.length) {
            if (nums[p2] - nums[p1] > middle) p1++;
            else {
                count += (p2 - p1);
                p2++;
            }
        }
        return count;
    }
}
