class Solution {
    public double myPow(double x, int n) {
        double pow = find (x, n);
        if (n < 0) pow = 1 / pow;
        return pow;
    }
    private double find (double x, int n) {
        // Base Case.
        if (n == 0) return 1;
        else if (n == 1) return x;

        // Recurrence Relation.
        double result1 = find(x, n / 2);
        
        result1 = result1 * result1;
        if (n % 2 != 0) {
            result1 *= x;
        }

        return result1;
    }
}
// Time Complexity: O(Log n)
// Space Complexity: O(Log n)
