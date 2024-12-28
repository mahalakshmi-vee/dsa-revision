class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        final int mod = 1000000007;
        long low = Math.min(a, b);
        long high = (long) n * Math.max(a, b);
        long middle = 0;
        long lcm = (long) (a * b) / gcd(a, b);
        long answer = 0;
        long count = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            count = getCount(middle, a, b, lcm);
            if (count >= n) {
                answer = middle;
                high = middle - 1;
            }
            else low = middle + 1;
        }
        return (int) (answer % mod);
    }
    private int gcd (int a, int b) {
        if (a == 0) return b;
        else if (b == 0) return a;
        if (a > b) return gcd(a % b, b);
        return gcd(b % a, a);
    }
    private long getCount(long number, int a, int b, long lcm) {
        long count = number / a;
        count += (number / b);
        count -= (number / lcm);
        return count;
    }
}