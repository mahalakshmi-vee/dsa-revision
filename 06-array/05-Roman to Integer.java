class Solution {
    public int romanToInt(String s) {
        // Time complexity is O(N) and space complexity is O(1), where N is the length of the input string 's'.
        Map<Character, Integer> romanNumeralsMap = new HashMap<>();
        romanNumeralsMap.put('I', 1);
        romanNumeralsMap.put('V', 5);
        romanNumeralsMap.put('X', 10);
        romanNumeralsMap.put('L', 50);
        romanNumeralsMap.put('C', 100);
        romanNumeralsMap.put('D', 500);
        romanNumeralsMap.put('M', 1000);
        int totalValue = 0;
        int currentRomanValue = 0;
        int previousRomanValue = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            currentRomanValue = romanNumeralsMap.get(s.charAt(i));
            if (currentRomanValue >= previousRomanValue) totalValue += currentRomanValue;
            else totalValue -= currentRomanValue;
            previousRomanValue = currentRomanValue;
        }
        return totalValue;
    }
}
