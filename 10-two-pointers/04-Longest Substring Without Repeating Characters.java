class Solution {
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        int leftPointer = 0;
        int rightPointer = 0;
        int answer = 0;
        while (rightPointer < s.length()) {
            char rightChar = s.charAt(rightPointer);
            frequencyMap.put(rightChar, frequencyMap.getOrDefault(rightChar, 0) + 1);
            if (frequencyMap.get(rightChar) > 1) {
                while (leftPointer < rightPointer) {
                    char leftChar = s.charAt(leftPointer);
                    frequencyMap.put(leftChar, frequencyMap.get(leftChar) - 1);
                    leftPointer++;
                    if (leftChar == rightChar) {
                        break;
                    }
                }
            }
            answer = Math.max(answer, rightPointer - leftPointer + 1);
            rightPointer++;
        }
        return answer;
    }
}
