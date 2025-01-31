class Solution {
    // Time Complexity: O(n c with k) - Binomial Coefficient
    // Space Complexity: O(n c with k)
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> listAnswer = new ArrayList<>();
        List<Integer> listNum = new ArrayList<>();
        for (int i = 1; i <= n; i++) listNum.add(i);
        backtrack (listNum, listAnswer, 0, new ArrayList<>(), k);
        return listAnswer;
    }
    private void backtrack (List<Integer> listNum, List<List<Integer>> listAnswer, int index, List<Integer> listSubAnswer, int k) {
        if (listSubAnswer.size() == k) {
            listAnswer.add(new ArrayList<>(listSubAnswer));
            return;
        }
        for (int i = index; i < listNum.size(); i++) {
            listSubAnswer.add(listNum.get(i));
            backtrack (listNum, listAnswer, i + 1, listSubAnswer, k);
            listSubAnswer.remove(listSubAnswer.size() - 1);
        }
    }
}
// Time Complexity Analysis:
// Binomial Coefficient is denoted as "n choose k" represents the number of ways to choose k elements from the set of n elements.
// We are generating all the possible valid combinations of k elements from the n elements. Hence the time complexity of this algorithm 
// is binomial coeeficient.
