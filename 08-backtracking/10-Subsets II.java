class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> listAnswer = new ArrayList<>();
        backtrack (listAnswer, nums, new ArrayList<>(), 0);
        return listAnswer;
    }
    private void backtrack (List<List<Integer>> listAnswer, int[] nums, List<Integer> listSubAnswer, int index) {
        if (index >= nums.length) {
            listAnswer.add(new ArrayList<>(listSubAnswer));
            return;
        }
        listSubAnswer.add(nums[index]);
        backtrack (listAnswer, nums, listSubAnswer, index + 1);
        listSubAnswer.remove(listSubAnswer.size() - 1);
        int nextIndex = index + 1;
        while (nextIndex < nums.length && nums[index] == nums[nextIndex]) nextIndex++;
        backtrack (listAnswer, nums, listSubAnswer, nextIndex);
    }
}

// Time Complexity: O(N * (2 ^ N))
// Space Complexity: O(N * (2 ^ N)) for storing all the possible subset in a list.
