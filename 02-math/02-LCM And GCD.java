class Solution {
    public static int[] lcmAndGcd(int a, int b) {
        int[] answerArr = new int[2];
        answerArr[1] = gcd(a, b);
        answerArr[0] = (a * b) / answerArr[1];
        return answerArr;
    }
    private static int gcd (int a, int b) {
        if (a == 0) return b;
        else if (b == 0) return a;
        if (a > b) return gcd(a % b, b);
        return gcd(b % a, a);
    }
}