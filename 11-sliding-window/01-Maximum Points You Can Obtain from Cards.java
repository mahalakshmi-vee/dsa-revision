class Solution {
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int maxScore(int[] cardPoints, int k) {
        int maxScore = 0;
        int score = 0;
        for (int i = 0; i < k; i++) {
            score += cardPoints[i];
        }
        maxScore = Math.max(maxScore, score);
        int n = cardPoints.length;
        int inElement = 0;
        int outElement = 0;
        int lastIndex = n - 1;
        for (int i = k - 1; i >= 0; i--) {
            outElement = cardPoints[i];
            score -= outElement;
            inElement = cardPoints[lastIndex--];
            score += inElement;
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }
}
// if k = 3,
// take 3 cards from left and 0 cards from right
// take 2 cards from left and 1 card from right
// take 1 card from left and 2 cards from right
// take 3 cards from left and 0 card from right
