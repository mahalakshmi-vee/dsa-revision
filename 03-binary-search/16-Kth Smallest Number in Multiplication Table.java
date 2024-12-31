class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m * n;
        int middle = 0;
        int countLessThan = 0;
        int countEqualTo = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            countLessThan = 0;
            countEqualTo = 0;

            int i = m - 1, j = 0;
            while (i >= 0 && j < n) {
                if ((i + 1) * (j + 1) > middle) i--;
                else if ((i + 1) * (j + 1) <= middle) {
                    if ((i + 1) * (j + 1) == middle) countEqualTo += (i + 1);
                    else countLessThan += (i + 1);
                    j++;
                }
            }

            if (countLessThan < k && countLessThan + countEqualTo == k) return middle;
            else if (countLessThan + countEqualTo >= k) high = middle - 1;
            else low = middle + 1;
        }
        return low;
    }
}

// Time complexity: O* ( (m + n) * Log(m * n) )
// Space complexity: O(1)