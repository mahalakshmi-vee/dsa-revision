class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long low = Math.min(Math.min(a, b), c);
        long high = (long) n * Math.max(Math.max(a, b), c);
        long middle = 0;
        long count = 0;
        long answer = 0;
        long lcm_a_b = lcm(a, b);
        long lcm_b_c = lcm(b, c);
        long lcm_c_a = lcm(c, a);
        long lcm_a_b_c = lcm(lcm_a_b, c);
        while (low <= high) {
            middle = (low + high) / 2;
            count = getCount(middle, a, b, c, lcm_a_b, lcm_b_c, lcm_c_a, lcm_a_b_c);
            if (count >= n) {
                answer = middle;
                high = middle - 1;
            }
            else low = middle + 1;
        }
        return (int) answer;
    }
    private long gcd (long a, long b) {
        if (a == 0) return b;
        else if (b == 0) return a;
        if (a > b) return gcd(a % b, b);
        return gcd(b % a, a);
    }
    private long lcm(long a, long b) {
        return (long) (a * b) / gcd (a, b);
    }
    private long getCount(long number, int a, int b, int c, long lcm_a_b, long lcm_b_c, long lcm_c_a, long lcm_a_b_c) {
        long count = (number / a);
        count += (number / b);
        count += (number / c);
        count += (number / lcm_a_b_c);
        count -= (number / lcm_a_b);
        count -= (number / lcm_b_c);
        count -= (number / lcm_c_a);
        return count;
    }
}