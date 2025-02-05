// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    boolean twoSum(int arr[], int target) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int neededValue = target - arr[i];
            if (hashSet.contains(neededValue)) return true;
            hashSet.add(arr[i]);
        }
        return false;
    }
}
