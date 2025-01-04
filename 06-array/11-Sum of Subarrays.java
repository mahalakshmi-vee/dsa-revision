class Solution {
    public long subarraySum(int[] arr) {
        int n = arr.length;
        long answer = 0;
        long sum = 0;
        long mod = 1000000007;
        // Brute force approach: Time complexity is O(N ^ 2) and space complexity is O(1).
        // for (int i = 0; i < n; i++) {
        //     sum = 0;
        //     for (int j = i; j < n; j++) {
        //         sum += arr[j];
        //         answer = ( (answer % mod) + (sum % mod) ) % mod;
        //     }
        // }
        // Efficient approach: Contribution technique and time complexity is O(N) and space complexity is O(1).
        for (int i = 0; i < n; i++) {
            //Calculating the contribution of the current ith element and adding it to the answer.
            sum = ( (( ((i + 1) % mod * (n - i) % mod) % mod ) % mod) * (1l * arr[i] % mod) ) % mod;
            answer = ( (answer % mod) + (sum % mod) ) % mod;
        }
        return answer;
    }
}
