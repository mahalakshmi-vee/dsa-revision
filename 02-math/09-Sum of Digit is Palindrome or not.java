class Solution {
    boolean isDigitSumPalindrome(int n) {
        int digitSum = 0;
        int input = n;
        while (input > 0) {
            digitSum += (input % 10);
            input /= 10;
        }
        
        input = digitSum;
        StringBuilder palindromeNumSB = new StringBuilder();
        while (input > 0) {
            palindromeNumSB.append(input % 10);
            input /= 10;
        }
        return Integer.valueOf(palindromeNumSB.toString()) == digitSum;
    }
}