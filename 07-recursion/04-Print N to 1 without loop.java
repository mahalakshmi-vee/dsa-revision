class Solution {
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    void printNos(int N) {
        // Base Case
        if (N < 1) return;
        System.out.print(N + " ");
        // Recurrence Relation
        printNos(N - 1);
    }
}
