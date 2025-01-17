class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> listAnswer = new ArrayList<>();
        // Brute force approach: Time complexity is O(NLogN) and space complexity is O(N) (used in in-built sorting functions).
        // Arrays.sort(nums);
        // for (int i = 0; i < n - 1; i++) {
        //     if (nums[i] == nums[i + 1]) listAnswer.add(nums[i]);
        // }
        // Brute force approach: Time complexity is O(N) and space complexity is O(N).
        // Set<Integer> hashSet = new HashSet<>();
        // for (int i = 0; i < n; i++) {
        //     if (hashSet.contains(nums[i])) listAnswer.add(nums[i]);
        //     hashSet.add(nums[i]);
        // } 
        // Optimized approach: Time complexity is O(N) and space complexity is O(1)
        for (int i = 0; i < n; i++) {
            int element = Math.abs(nums[i]) - 1;
            if (nums[element] < 0) { // represents that the element is seen already.
                listAnswer.add(Math.abs(nums[i]));
            }
            else {
                nums[element] *= -1;
            }
        }
        return listAnswer;
    }
}
