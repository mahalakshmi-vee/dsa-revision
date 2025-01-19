class Solution {
    public int myAtoi(String s) {
        int index = 0;
        int sign = 1;
        int result = 0;
        int n = s.length();
        while (index < n && s.charAt(index) == ' ') index++;
        if (index < n && s.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        else if (index < n && s.charAt(index) == '+') index++;
        int value = 0;
        while (index < n) {
            value = s.charAt(index) - '0';
            if (value >= 0 && value <= 9) {
                if (result > (Integer.MAX_VALUE - value) / 10) { // To make sure that the computation will not lead to overflow issue.
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result = (result * 10) + value; 
            }
            else break;
            index++;
        }
        result = result * sign;
        return result;
    }
}
