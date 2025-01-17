class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        // Sliding window algorithm. Time complexity is O(N + M) where N represents s1 length and M represents s2 length.
        // Space complexity is O(N + M). 
        int windowSize = s1.length();
        int totalWindow = s2.length() - windowSize;
        Map<Character, Integer> s1_FrequencyMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) s1_FrequencyMap.put(s1.charAt(i), s1_FrequencyMap.getOrDefault(s1.charAt(i), 0) + 1);
        Map<Character, Integer> s2_FrequencyMap = new HashMap<>();
        for (int i = 0; i < windowSize; i++) {
            s2_FrequencyMap.put(s2.charAt(i), s2_FrequencyMap.getOrDefault(s2.charAt(i), 0) + 1);
        }
        if (check(s1_FrequencyMap, s2_FrequencyMap)) return true;
        char inElement = '\0';
        char outElement = '\0';
        for (int i = 1; i <= totalWindow; i++) {
            inElement = s2.charAt(i + windowSize - 1);
            outElement = s2.charAt(i - 1);
            s2_FrequencyMap.put(inElement, s2_FrequencyMap.getOrDefault(inElement, 0) + 1);
            s2_FrequencyMap.put(outElement, s2_FrequencyMap.get(outElement) - 1);
            if (check(s1_FrequencyMap, s2_FrequencyMap)) return true;
        }   
        return false;
    }
    private boolean check (Map<Character, Integer> s1_FrequencyMap, Map<Character, Integer> s2_FrequencyMap) {
        for (Map.Entry<Character, Integer> entry : s1_FrequencyMap.entrySet()) {
            if (!s2_FrequencyMap.containsKey(entry.getKey())) return false;
            if (s2_FrequencyMap.get(entry.getKey()) < s1_FrequencyMap.get(entry.getKey())) return false;
        }
        return true;
    }
}
