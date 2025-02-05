class Solution {
    // Time Complexity: O(Log N) with base value between 2 and 5
    // Space Complexity: O(1)
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        int[] primes = {2,3,5};
        for (int prime : primes) {
            while (n % prime == 0) {
                n = n / prime;
            }
        }
        return n == 1;
    }
}
