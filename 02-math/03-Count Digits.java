class Solution {
    static int evenlyDivides(int n) {
        int answer = 0;
        int input = n;
        int digit = 0;
        while (input > 0) {
            digit = input % 10;
            if (digit > 0 && n % digit == 0) answer++;
            input /= 10;
        }
        return answer;
    }
}