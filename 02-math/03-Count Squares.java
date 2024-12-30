class Solution {
    static int countSquares(int n) {
        int answer = 0;
        // Brute force approach and time complexity is O(N).
        // int sqrt = 0;
        // for (int i = 1; i < n; i++) {
        //     sqrt = (int) Math.sqrt(i);
        //     if (sqrt * sqrt == i) {
        //         answer++;
        //     }
        // }
        // Optimized approach and time complexity is O(SQRT(N)).
        for (int i = 1; i * i < n; i++) {
            answer++;
        }
        return answer;
    }
}