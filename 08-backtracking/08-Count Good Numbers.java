class Solution {
    private static final long EVEN_COUNT = 5l;
    private static final long PRIME_COUNT = 4l;
    private static final int mod = 1000000007;

    // Time Complexity: O(Log N)
    // Space Complexity: O(Log N)        
    public int countGoodNumbers(long n) {
        if (n == 1) return (int) EVEN_COUNT;
        long totalEvenIndices = n / 2;
        if (n % 2 != 0) totalEvenIndices++;
        long totalOddIndices = n - totalEvenIndices;
        return (int) ( (  pow(EVEN_COUNT, totalEvenIndices) % mod * pow(PRIME_COUNT, totalOddIndices) % mod ) % mod );
    }

    private int bruteForce (long n) {
        long answer = 1l;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                answer = ( (answer % mod) * (EVEN_COUNT % mod) ) % mod;
            }
            else {
                answer = ( (answer % mod) * (PRIME_COUNT % mod) ) % mod;
            }
        }
        return (int) answer % mod;
    }

    private long pow (long a, long b) {
        if (b == 0) return 1;
        else if (b == 1) return a;

        long answer = pow(a, b / 2);
        answer = ( (answer % mod) * (answer % mod) ) % mod;
        if (b % 2 != 0) {
            answer = ( (answer % mod) * (a % mod) ) % mod;
        }
        return answer % mod;
    }
}
