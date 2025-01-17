class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        // Time complexity is O(N) and space complexity is O(N).
        Map<Character, Character> hashMap = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                if (hashMap.get(s.charAt(i)) != t.charAt(i)) return false;
            }
            else {
                if (hashMap.containsValue(t.charAt(i))) return false;
                hashMap.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
