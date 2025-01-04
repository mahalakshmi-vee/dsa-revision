class Solution {
    public boolean isAnagram(String s, String t) {
        // Time complexity is O(N) and space complexity is O(1), where N is the length of the input string. 
        if (s.length() != t.length()) return false;
        int[] frequencyArray = new int[26];
        int ascii = 0;
        for (int i = 0; i < s.length(); i++) {
            ascii = s.charAt(i) - 97;
            frequencyArray[ascii]++;
        }
        for (int i = 0; i < t.length(); i++) {
            ascii = t.charAt(i) - 97;
            frequencyArray[ascii]--;
        }
        for (int i = 0; i < frequencyArray.length; i++) {
            if (frequencyArray[i] != 0) return false;
        }
        return true;
    }
}
