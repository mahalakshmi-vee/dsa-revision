class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        // Solved using Bit Manipulation.
        // Time Complexity: O(1)
        // Space Complexity: O(1)
        // int numberOfSetBits = 0;
        // for (int i = 0; i < 32; i++) {
        //     if ((n & (1 << i)) != 0) numberOfSetBits++;
        // }
        // return numberOfSetBits == 1;
        return find (n);
    }
    // Solved using Recursion.
    // Time Complexity: O(log n)
    // Space Complexity: O(log n)
    private boolean find (int n) {
        // Base case.
        if (n == 0) return true;
        else if (n > 1 && n % 2 != 0) return false;
        // Recurrence Relation.
        return find (n / 2);
    }
}
