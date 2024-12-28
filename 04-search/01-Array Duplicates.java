class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        List<Integer> listAnswer = new ArrayList<>();
        Set<Integer> hashSet = new HashSet<>();
        for ( int i = 0; i < arr.length; i++ ) {
            if (hashSet.contains(arr[i])) listAnswer.add(arr[i]);
            hashSet.add(arr[i]);
        }
        return listAnswer;
    }
}
// Time complexity: O(N)
// Space complexity: O(1)