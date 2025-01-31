class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> listAnswer = new ArrayList<>();
        List<Integer> listNumber = new ArrayList<>();
        for (int i = 1; i <= 9; i++) listNumber.add(i);
        find (listNumber, listAnswer, new ArrayList<>(), k, n, 0);
        return listAnswer;
    }
    private void find (List<Integer> listNumber, List<List<Integer>> listAnswer, List<Integer> listSubAnswer, int k, int n, int index) {
        if (listSubAnswer.size() == k && n == 0) {
            listAnswer.add(new ArrayList<>(listSubAnswer));
            return;
        }
        else if (index >= 9 || listNumber.get(index) > n) {
            return;
        }

        listSubAnswer.add(listNumber.get(index));
        find (listNumber, listAnswer, listSubAnswer, k, n - listNumber.get(index), index + 1);
        
        listSubAnswer.remove(listSubAnswer.size() - 1);
        find (listNumber, listAnswer, listSubAnswer, k, n, index + 1);
    }
}

// Time and Space Complexity:
// Time Complexity: O(2 ^ K)
// Space Complexity: O(K) 
