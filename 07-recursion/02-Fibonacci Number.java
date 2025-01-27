class Solution {
    public int fib(int n) {
        // Base Case.
        if (n <= 1) return n;
        // Recurrence Relation.
        return fib(n - 1) + fib(n - 2);
    }
}
// Space Complexity: O(N)
// * The space complexity is determined by the maximum depth of the recursion stack, which is proportional to 'n' in this case.
// * Therefore, the space complexity is O(N). 
// Time Complexity: O(2 ^ N)
// * The function makes 2 recursive calls for each invocation.
// * The recursion tree has a height of n, and at each level, the number of calls roughly doubles.
// * This leads to a time complexity of O(2 ^ n) as the recursion tree grows exponentially.
