class Solution {
    // Time complexity O(NLogN) and space complexity is O(1).
    boolean findSwapValues(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        
        int m = a.length;
        int n = b.length;        
        
        int sum_a = 0;
        for (int i = 0; i < m; i++) sum_a += a[i];
        int sum_b = 0;
        for (int i = 0; i < n; i++) sum_b += b[i];
        
        if ((sum_a - sum_b) % 2 != 0) return false;

        int target = (sum_a - sum_b) / 2;
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < m && pointer2 < n) {
            int diff = a[pointer1] - b[pointer2];
            if (diff == target) {
                return true;
            }
            else if (diff > target) pointer2++;
            else pointer1++;
        }
        return false;
    }
    // Optimized approach explanation:
    // sum_a - a[i] + b[j] = sum_b - b[j] + a[i]
    // sum_a - sum_b = 2(a[i] - b[j])
    // a[i] - b[j] = (sum_a - sum_b) / 2
    
    // target = (sum_a - sum_b) / 2;
    
    // if (sum_a - sum_b) is not divisible by 2 we can find pair of elements by choosing one from 
    // array 'a' and one from array 'b' hence we need to return immediately false
    
    // else case
    
    // Need to sort the two arrays to find a pair elements one from each array.
    
    // diff = a[pointer1] - b[pointer2];
    
    // if diff == target we found a pair hence return true.
    // else if diff > target means element in array 'a' is large hence we need to increment pointer2
    // else increment pointer1
    
    // Brute/Very Naive force approach: Got TLE.
    // Time complexity is O(N ^ 2) and space complexity is O(1).
    boolean findSwapValuesBruteForce(int[] a, int[] b) {
        int sum_a = 0;
        int sum_b = 0;
        for (int i = 0; i < a.length; i++) sum_a += a[i];
        for (int i = 0; i < b.length; i++) sum_b += b[i];
        
        if (sum_a == sum_b) return true;
        
        for (int i = 0; i < a.length; i++) {
            int element1 = a[i];
            for (int j = 0; j < b.length; j++) {
                int element2 = b[j];
                if (sum_a - element1 + element2 == sum_b - element2 + element1) {
                    return true;
                }
            }
        }
        
        
        for (int i = 0; i < b.length; i++) {
            int element1 = b[i];
            for (int j = 0; j < a.length; j++) {
                int element2 = a[j];
                if (sum_b - element1 + element2 == sum_a - element2 + element1) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
