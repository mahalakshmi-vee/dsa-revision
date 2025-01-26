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
// Optimal Approach: Time complexity is O(N ^ 2) and space complexity is O(N).
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> listNum = new ArrayList<>();
        for (int i = 1; i <= n; i++) listNum.add(i);

        StringBuilder strPermutation = new StringBuilder();
        int permutations = n - 1;
        k--;
        while (permutations >= 0) {
            int fact = fact(permutations);
            int index = k / fact;
            strPermutation.append(listNum.get(index));
            listNum.remove(index);
            permutations--;
            k = k % fact;
        }        
        return strPermutation.toString();
    }
    private int fact (int n) {
        if (n <= 1) return 1;

        return n * fact(n - 1);
    }
}

// Example: n = 4 and k = 16
// Elements in the set are {1, 2, 3, 4}

// 1 + {2, 3, 4} => 3! = 6 => [0 - 5]    (0)
// 2 + {1, 3, 4} => 3! = 6 => [6 - 11]   (1)
// 3 + {1, 2, 4} => 3! = 6 => [12 - 17]  (2)
// 4 + {1, 2, 3} => 3! = 6 => [18 - 23]  (3)

// So my answer will be in between the range [12 - 17] and hence I can ignore considering the other sets.
// 16 / 6 = 2  => 3 + {1, 2, 4} => 3! = 6 => [12 - 17]  (2)
// Picked up 3.

// The problem boiled down now and the set contains {1, 2, 4} and k = 16 % 6 => 4

// 1 + {2, 4} => 2! = 2 [0 - 1]  (0)
// 2 + {1, 4} => 2! = 2 [1 - 2]  (1)
// 4 + {1, 2} => 2! = 2 [2 - 3]  (2)

// So my answer will be in between the range [2 - 3] and hence I can ignore considering the other sets.
// 4 / 2 = 2 => 4 + {1, 2} => 2! = 2 [2 - 3]  (2)
// Picked up 4

// The problem boiled down now and the set contains {1, 2} and k = 4 % 2 => 0

// 1 + {2} => 1! = 1 [0 - 0]   (0)
// 2 + {1} => 1! = 1 [1 - 1]   (1)

// So my answer will be in between the range [0 - 0] and hence I can ignore considering the other sets.
// 0 / 1 = 0 => 1 + {2} => 1! = 1 [0 - 0]   (0)
// Picked up 1.

// The problem boiled down now and the set contains {2} and k = 0 % 1 => 0
// 2 
// Picked up 2.
