class Solution {
    public int subarraySum(int[] nums, int k) {
        // Brute Force Approach: Time complexity is O(N ^ 2) and space complexity is O(1).
        // int answer = 0;
        // int sum = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     sum = 0;
        //     for (int j = i; j < nums.length; j++) {
        //         sum += nums[j];
        //         if (sum == k) answer++;
        //     }
        // }
        // return answer;
        // Optimized Approach: Time complexity is O(N) and space complexity is O(N).
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int sum = 0;
        int neededValue = 0;
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            neededValue = sum - k;
            if (hashMap.containsKey(neededValue)) {
                answer += hashMap.get(neededValue);
            }
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }
        return answer;
    }
}