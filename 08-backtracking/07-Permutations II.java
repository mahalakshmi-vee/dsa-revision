class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
        }   
        List<List<Integer>> listAnswer = new ArrayList<>();
        find (listAnswer, new ArrayList<>(), nums, frequencyMap);
        return listAnswer;
    }
    private void find (List<List<Integer>> listAnswer, List<Integer> listSubAnswer, int[] nums, Map<Integer, Integer> frequencyMap) {
        if (listSubAnswer.size() == nums.length) {
            listAnswer.add(new ArrayList<>(listSubAnswer));
            return;
        }
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 0) continue;
            frequencyMap.put(entry.getKey(), entry.getValue() - 1);
            listSubAnswer.add(entry.getKey());
            find (listAnswer, listSubAnswer, nums, frequencyMap);
            listSubAnswer.remove(listSubAnswer.size() - 1);
            frequencyMap.put(entry.getKey(), entry.getValue() + 1);
        }
    }
}
// Time and Space Complexity Analysis:
// Time Complexity: O(N * N!)
// Space Complexity: O(N * N!) for storing the result
// The number of permutations of an array of n is exactly n! This is because:
// * The first element can be of the n elements
// * The second element can be of the n - 1 elements
// * The third element can be of the n - 2 elements and so on.
// n * (n - 1) * (n - 2) * (n - 3)..... 1 => n!
