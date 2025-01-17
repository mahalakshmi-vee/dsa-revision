class Solution {
    public int maxProduct(int[] nums) {
        int answer = Integer.MIN_VALUE;
        int n = nums.length;
        int subAnswer = 1;
        // Brute force approach: Time complexity is O(N ^ 2) and space complexity is O(1)
        // for (int i = 0; i < n; i++) {
        //     subAnswer = 1;
        //     for (int j = i; j < n; j++) {
        //         subAnswer *= nums[j];
        //         answer = Math.max(answer, subAnswer);
        //     }
        // }
        // Optimized approach: Time complexity is O(N) and space complexity is O(1)
        int pre = 1;
        int suf = 1;
        for (int i = 0; i < n; i++) {
            if (pre == 0) pre = 1;
            if (suf == 0) suf = 1;
            pre *= nums[i];
            suf *= nums[n - i - 1];
            answer = Math.max(answer, Math.max(pre, suf));
        }
        return answer;
    }
}
