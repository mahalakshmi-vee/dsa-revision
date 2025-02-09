
class Solution {
    public int longestkSubstr(String s, int k) {
        // Brute force approach:
        // Time Complexity: O(N ^ 2)
        // Space Complexity: O(N ^ 2)
        // int n = s.length();
        // int answer = -1;
        // for (int i = 0; i < n; i++) {
        //     Set<Character> hashSet = new HashSet<>();
        //     for (int j = i; j < n; j++) {
        //         hashSet.add(s.charAt(j));
        //         if (hashSet.size() == k) {
        //             answer = Math.max(answer, j - i + 1);
        //         }
        //     }
        // }
        // return answer;
        // Optimized approach: Using Sliding window technique.
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        int n = s.length();
        int leftPointer = 0;
        int rightPointer = 0;
        int answer = -1;
        Map<Character, Integer> hashMap = new HashMap<>();
        while(rightPointer < n) {
            hashMap.put(s.charAt(rightPointer), hashMap.getOrDefault(s.charAt(rightPointer), 0) + 1);
            while (leftPointer <= rightPointer && hashMap.size() > k) {
                hashMap.put(s.charAt(leftPointer), hashMap.get(s.charAt(leftPointer)) - 1);
                if (hashMap.get(s.charAt(leftPointer)) == 0) 
                    hashMap.remove(s.charAt(leftPointer));
                leftPointer++;
            }
            if (hashMap.size() == k)
                answer = Math.max(answer, rightPointer - leftPointer + 1);
            rightPointer++;
        }
        return answer;
    }
}
