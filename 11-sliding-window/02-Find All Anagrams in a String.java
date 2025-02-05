class Solution {
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> listAnswer = new ArrayList<>();
        if (p.length() > s.length()) return listAnswer;
        int[] frequencyArr_P = new int[26];
        int ascii = 0;
        for (int i = 0; i < p.length(); i++) {
            ascii = p.charAt(i) - 97;
            frequencyArr_P[ascii]++;
        } 
        int[] frequencyArr_S = new int[26];
        int n = s.length();
        int totalWindow = n - p.length();
        for (int i = 0; i < p.length(); i++) {
            ascii = s.charAt(i) - 97;
            frequencyArr_S[ascii]++;
        }
        if (check(frequencyArr_P, frequencyArr_S)) {
            listAnswer.add(0);
        }
        for (int i = 1; i <= totalWindow; i++) {
            int inElement = s.charAt(i + p.length() - 1) - 97;
            int outElement = s.charAt(i - 1) - 97;
            frequencyArr_S[inElement]++;
            frequencyArr_S[outElement]--;
            if (check(frequencyArr_P, frequencyArr_S)) {
                listAnswer.add(i);
            }
        }
        return listAnswer;
    }
    private boolean check (int[] frequencyArr_P, int[] frequencyArr_S) {
        for (int i = 0; i < frequencyArr_P.length; i++) {
            if (frequencyArr_P[i] != frequencyArr_S[i]) return false;
        }
        return true;
    }
}
