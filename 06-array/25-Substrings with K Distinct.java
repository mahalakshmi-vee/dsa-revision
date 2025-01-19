class Solution {
    int countSubstr(String s, int k) {
        // Brute force approach - Got TLE exception.
        // Time complexity is O(N ^ 3) and space complexity is O(1).
        // Set<Character> hashSet = new HashSet<>();
        // for (int i = 0; i < n; i++) {
        //     for (int j = i; j < n; j++) {
        //         hashSet = new HashSet<>();
        //         for (int l = i; l <= j; l++) {
        //             hashSet.add(s.charAt(l));
        //         }
        //         if (hashSet.size() == k) answer++;
        //     }    
        // }
        // Optimized approach: Sliding window and two pointers.
        // Time complexity is O(N) and space complexity is O(K).
        // Space complexity is O(N) for worst case.
        // number of substring that have exactly k distinct characters =
        // number of substring that have atmost k distinct characters -
        // number of substring that have atmost k - 1 distinct characters.
        return getCount(s, k) - getCount(s, k - 1);
    }
    private int getCount (String s, int k) {
        int n = s.length();
        int answer = 0;
        Map<Character, Integer> hashMap = new HashMap<>();
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer2 < n) {
            hashMap.put(s.charAt(pointer2), hashMap.getOrDefault(s.charAt(pointer2),0) + 1);
            while (hashMap.size() > k) { // Shrink the window.
                hashMap.put(s.charAt(pointer1), hashMap.get(s.charAt(pointer1)) - 1);
                if (hashMap.get(s.charAt(pointer1)) == 0) hashMap.remove(s.charAt(pointer1));
                pointer1++;
            }
            answer += (pointer2 - pointer1 + 1);
            pointer2++;
        }
        return answer;
    }
}
