class Solution {
    public int addDigits(int num) {
        int input = num;
        while (input > 9) {
            int subInput = input;
            input = 0;
            while (subInput > 0) {
                input += (subInput % 10);
                subInput /= 10;
            }
        }
        return input;
    }
}