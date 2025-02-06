// Time Complexity: O(N)
// Space Complexity: O(1) // frequencyMap will always have the size of 26 even though the input string dynamically grown or shrink
class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        int n = s.length();
        int maxFrequency = 0;
        int answer = 0;
        int leftPointer = 0;
        int rightPointer = 0;
        char rightChar = '\0';
        char leftChar = '\0';
        while (rightPointer < n) {
            rightChar = s.charAt(rightPointer);
            frequencyMap.put(rightChar, frequencyMap.getOrDefault(rightChar, 0) + 1);
            maxFrequency = Math.max(maxFrequency, frequencyMap.get(rightChar));
            while ((rightPointer - leftPointer + 1) - maxFrequency > k) {
                leftChar = s.charAt(leftPointer);
                frequencyMap.put(leftChar, frequencyMap.get(leftChar) - 1);
                leftPointer++;
            }
            rightPointer++;
            answer = Math.max(answer, rightPointer - leftPointer);
        }
        return answer;
    }
}
