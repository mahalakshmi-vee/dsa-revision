class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> listAnswer = new ArrayList<>();
        // Brute force approach: Time complexity is O(N) and space complexity is O(N). 
        // Map<Integer, Integer> hashMap = new HashMap<>();
        // for (int i = 0; i < n; i++) hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        // for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
        //     if (entry.getValue() > n / 3) listAnswer.add(entry.getKey());
        // }
        // Optimized approach: Moore's voting algorithm.
        // Time complexity is O(N) and space complexity is O(1).
        int vote1 = 0;
        int vote2 = 0;
        int majorityElement1 = 0;
        int majorityElement2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == majorityElement1) vote1++;
            else if (nums[i] == majorityElement2) vote2++;
            else if (vote1 == 0) {
                majorityElement1 = nums[i];
                vote1++;
            }
            else if (vote2 == 0) {
                majorityElement2 = nums[i];
                vote2++;
            }
            else {
                vote1--;
                vote2--;
            }
        }
        vote1 = 0;
        vote2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == majorityElement1) vote1++;
            else if (nums[i] == majorityElement2) vote2++;
        }
        if (vote1 > n / 3) listAnswer.add(majorityElement1);
        if (vote2 > n / 3) listAnswer.add(majorityElement2);
        return listAnswer;
    }
}
