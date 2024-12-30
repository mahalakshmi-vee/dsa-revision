class Solution {
    static boolean armstrongNumber(int n) {
        int armStrongNumber = 0;
        int input = n;
        int digit = 0;
        while (input > 0) {
            digit = input % 10;
            armStrongNumber += (digit * digit * digit);
            input /= 10;
        }
        return armStrongNumber == n;
    }
}