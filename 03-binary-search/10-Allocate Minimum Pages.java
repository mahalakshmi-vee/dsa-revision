class Solution {
    public static int findPages(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return -1;
        int low = 0;
        int high = 0;
        for (int i = 0; i < n; i++) {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }
        int middle = 0;
        int answer = low;
        int totalStudent = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            totalStudent = getTotalStudent(middle, arr);
            if (totalStudent >= k) {
                answer = middle;
                low = middle + 1;
            }
            else high = middle - 1;
        }
        return answer;
    }
    private static int getTotalStudent(int minNumberOfPagesAssignedToAnyStud, int[] arr) {
        int totalStudent = 0;
        int totalPagesAllocated = 0;
        for (int i = 0; i < arr.length; i++) {
            totalPagesAllocated += arr[i];
            if (totalPagesAllocated >= minNumberOfPagesAssignedToAnyStud) {
                totalStudent++;
                totalPagesAllocated = arr[i];
            }
        }
        return totalStudent;
    }
}