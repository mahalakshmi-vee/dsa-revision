class Solution {
    // Time Complexity: O(N ^ 2)
    // Space Complexity: O(N)
    public boolean wordBreak(String s, List<String> wordDict) {
        int strLength = s.length();
        int[] dp = new int[strLength];
        Arrays.fill(dp, -1);

        return helper(s, 0, wordDict, dp);
    }
    private boolean helper (String s, int index, List<String> wordDict, int[] dp) {
        if (index == s.length()) return true;
        else if (dp[index] != -1) return dp[index] == 1 ? true : false;

        for (int i = index; i < s.length(); i++) {
            if (wordDict.contains(s.substring(index, i + 1))) {
                if (helper (s, i + 1, wordDict, dp)) {
                    dp[index] = 1;
                    return true;
                }
            }
        }

        dp[index] = 0;
        return false;
    }
}
