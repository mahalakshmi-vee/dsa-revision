class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int totalOpen = 0;
        int answer = 0;
        // Time complexity is O(N) and space complexity is O(1).
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') totalOpen++;
            else if (s.charAt(i) == ')') totalOpen--;
            answer = Math.max(answer, totalOpen);
        }
        return answer;
    }
}
