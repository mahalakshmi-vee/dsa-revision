class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> listAnswer = new ArrayList<>();
        find (listAnswer, candidates, target, 0, new ArrayList<>());
        return listAnswer;
    }
    private void find (List<List<Integer>> listAnswer, int[] candidates, int target, int index, List<Integer> listSubAnswer) {
        if (target == 0) {
            listAnswer.add(new ArrayList<>(listSubAnswer));
            return;
        }
        else if (index >= candidates.length || candidates[index] > target) {
            return;
        }

        // include the element
        listSubAnswer.add(candidates[index]);
        find (listAnswer, candidates, target - candidates[index], index, listSubAnswer);

        // exclude the element
        listSubAnswer.remove(listSubAnswer.size() - 1);
        find (listAnswer, candidates, target, index + 1, listSubAnswer);
    }
}

// Time and Space Complexity:
// Time Complexity: (2 ^ T)
// Space Complexity: O(T)
