class Solution {
    public void reverseString(char[] s) {
        // Solved using Two Pointers technique.
        // int leftPointer = 0;
        // int rightPointer = s.length - 1;
        // while (leftPointer < rightPointer) {
        //     char temp = s[leftPointer];
        //     s[leftPointer] = s[rightPointer];
        //     s[rightPointer] = temp;
        //     leftPointer++;
        //     rightPointer--;
        // }
        // Solved using Strings.
        // StringBuilder inputStr = new StringBuilder(new String(s));
        // inputStr = new StringBuilder(inputStr.reverse());
        // for (int i = 0; i < s.length; i++) {
        //     s[i] = inputStr.toString().charAt(i);
        // }
        reverse(s, 0, s.length - 1);   
    }
    // Solved using Recursion.
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    private void reverse(char[] s, int leftPointer, int rightPointer) {
        // Base Case.
        if (leftPointer >= rightPointer) return;

        // Recurrence Relation.
        char temp = s[leftPointer];
        s[leftPointer] = s[rightPointer];
        s[rightPointer] = temp;

        reverse(s, leftPointer + 1, rightPointer - 1);
    }
}
