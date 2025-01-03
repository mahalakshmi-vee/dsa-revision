class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        // Brute force approach: Time complexity is O(N ^ 2) and space complexity is O(1).
        List<Integer> listAnswer = new ArrayList<>();
        // int count = 0;
        // for (int i = 0; i < n; i++) {
        //     count = 0;
        //     for (int j = i + 1; j < n; j++) {
        //         if (nums[j] < nums[i])
        //             count++;
        //     }
        //     listAnswer.add(count);
        // }
        // Optimized approach (using mergesort): Time complexity is O(LogN) and space complexity is O(N).
        int[] answerArray = new int[n];
        int[][] numsArray = new int[n][2];
        for (int i = 0; i < n; i++) {
            numsArray[i][0] = nums[i];
            numsArray[i][1] = i;
        }
        mergeSort(numsArray, 0, n - 1, answerArray);
        for (int i = 0; i < n; i++) listAnswer.add(answerArray[i]);
        return listAnswer;
    }
    private void mergeSort (int[][] numsArray, int start, int end, int[] answerArray) {
        if (start >= end) return;

        int middle = (start + end) / 2;
        mergeSort(numsArray, start, middle, answerArray);
        mergeSort(numsArray, middle + 1, end, answerArray);
        merge(numsArray, start, middle, end, answerArray);
    }
    private void merge (int[][] numsArray, int start, int middle, int end, int[] answerArray) {
        int[][] mergedArray = new int[end - start + 1][2];
        int pointer1 = start;
        int pointer2 = middle + 1;
        int pointer3 = 0;
        while (pointer1 <= middle && pointer2 <= end) {
            if (numsArray[pointer1][0] > numsArray[pointer2][0]) {
                answerArray[numsArray[pointer1][1]] += (end - pointer2 + 1);
                mergedArray[pointer3++] = numsArray[pointer1++];
            }
            else {
                mergedArray[pointer3++] = numsArray[pointer2++];
            }
        }
        while (pointer1 <= middle) {
            mergedArray[pointer3++] = numsArray[pointer1++];
        }
        while (pointer2 <= end) {
            mergedArray[pointer3++] = numsArray[pointer2++];
        }
        pointer3 = 0;
        for (int i = start; i <= end; i++) {
            numsArray[i] = mergedArray[pointer3++];
        }
    }
}
