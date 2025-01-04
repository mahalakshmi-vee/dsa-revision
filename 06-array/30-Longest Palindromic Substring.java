class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        // Brute force approach: Time complexity is O(N ^ 2) and space complexity is O(N), where N is the length of the input string.
        // String longestPalindrome = "";
        // for (int i = 0; i < n; i++) {
        //     for (int j = i; j < n; j++) {
        //         if (isPalindrome(s.substring(i, j + 1)) && (j - i + 1) > longestPalindrome.length()) {
        //             longestPalindrome = s.substring(i, j + 1);
        //         }
        //     }
        // }
        // return longestPalindrome;
        // Efficient approach: Expansion from center and time complexity is O(N) and space complexity is O(1).
        int[] answerArray = new int[2];
        Arrays.fill(answerArray, -1);
        for (int i = 0; i < n; i++) {
            expand(i, i, s, answerArray);
            expand(i, i + 1, s, answerArray);    
        }
        if (answerArray[0] == -1 || answerArray[1] == -1) return "";
        return s.substring(answerArray[0], answerArray[1] + 1);
    }
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
    private void expand(int center1, int center2, String str, int[] answerArray) {
        while (center1 >= 0 && center2 < str.length() && str.charAt(center1) == str.charAt(center2)) {
            if (answerArray[1] - answerArray[0] < (center2 - center1 + 1)) {
                answerArray[0] = center1;
                answerArray[1] = center2;
            }
            center1--;
            center2++;
        }
    }
}
