// Brute force approach using recursion.
// Time complexity is O(N * N!)
// Space complexity is O(N * N!)
// Number methods will be in the stack at any point time at the maximum is N.
// N * N! is because of storing all the possible permutations as a list of string.

// class Solution {
//     public String getPermutation(int n, int k) {
//         List<Integer> listNum = new ArrayList<>();
//         for (int i = 1; i <= n; i++) listNum.add(i);

//         List<String> listAllPermutations = new ArrayList<>();
//         getListAllPermutations(listNum, listAllPermutations,new ArrayList<>());
//         return listAllPermutations.get(k - 1);
//     }
//     private void getListAllPermutations (List<Integer> listNum, List<String> listAllPermutations, List<Integer> listSub) {
//         if (listSub.size() == listNum.size()) {
//             StringBuilder sb = new StringBuilder();
//             for (int sub : listSub) sb.append(sub);
//             listAllPermutations.add(sb.toString());
//             return;
//         }

//         for (int num : listNum) {
//             if (listSub.contains(num)) continue;
//             listSub.add(num);
//             getListAllPermutations(listNum, listAllPermutations, listSub);
//             listSub.remove(listSub.size() - 1);
//         }
//     }
// }
