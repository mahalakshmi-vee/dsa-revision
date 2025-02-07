class Solution {
    // Time Complexity: O(N * M)
    // Space Complexity: O(N + M)
    public String minWindow(String s, String t) {
        Map<Character, Integer> frequencyMap_t = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            frequencyMap_t.put(t.charAt(i), frequencyMap_t.getOrDefault(t.charAt(i), 0) + 1);
        }       
        Map<Character, Integer> frequencyMap_s = new HashMap<>();
        int leftPointer = 0;
        int rightPointer = 0;
        int n = s.length();
        int answer = n + 1;
        int startIndex = -1;
        int endIndex = -1;
        char rightChar = '\0';
        char leftChar = '\0';
        while (rightPointer < n) {
            rightChar = s.charAt(rightPointer);
            frequencyMap_s.put(rightChar, frequencyMap_s.getOrDefault(rightChar, 0) + 1);
            if (checkMap(frequencyMap_t, frequencyMap_s)) {
                boolean blnBreak = false;
                while (leftPointer <= rightPointer && !blnBreak) {
                    leftChar = s.charAt(leftPointer);
                    if (rightPointer - leftPointer + 1 < answer) {
                        answer = rightPointer - leftPointer + 1;
                        startIndex = leftPointer;
                        endIndex = rightPointer;
                    }
                    answer = Math.min(answer, rightPointer - leftPointer + 1);
                    frequencyMap_s.put(leftChar, frequencyMap_s.get(leftChar) - 1);
                    leftPointer++;
                    blnBreak = !checkMap(frequencyMap_t, frequencyMap_s);
                }
            }
            rightPointer++;
        }
        if (startIndex == -1 || endIndex == -1) return "";
        return s.substring(startIndex, endIndex + 1);
    }
    private boolean checkMap (Map<Character, Integer> frequencyMap_t, Map<Character, Integer> frequencyMap_s) {
        for (Map.Entry<Character, Integer> entry : frequencyMap_t.entrySet()) {
            if (!frequencyMap_s.containsKey(entry.getKey()) || frequencyMap_s.get(entry.getKey()) < entry.getValue()) return false;
        }
        return true;
    }
}
