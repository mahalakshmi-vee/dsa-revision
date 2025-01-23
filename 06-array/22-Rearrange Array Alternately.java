class Solution {

    // temp: input array
    // n: size of array
    // Function to rearrange  the array elements alternately.
    public static void rearrange(int arr[]) {
        Arrays.sort(arr);
        int n = arr.length;
        
        // Time complexity: O(NLogN) and space complexity: O(N).
        // Submitted Brute force approach.
        // int leftPointer = 0;
        // int rightPointer = n - 1;
        // int[] resultantArray = new int[n];
        // int index = 0;
        // while (leftPointer < rightPointer) {
        //     resultantArray[index++] = arr[rightPointer--];
        //     resultantArray[index++] = arr[leftPointer++];
        // }
        // if (leftPointer == rightPointer) resultantArray[index] = arr[leftPointer];
        // for (int i = 0; i < resultantArray.length; i++) arr[i] = resultantArray[i];
        
        // Optimized approach is to manipulate the array itself using the modulo operation.
        // Time complexity: O(NLogN) and space complexity: O(1)
        int maximumElement = arr[n - 1] + 1;
        int leftPointer = 0;
        int rightPointer = n - 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) arr[i] += (arr[rightPointer--] % maximumElement) * maximumElement;
            else arr[i] += (arr[leftPointer++] % maximumElement) * maximumElement;
        }
        for (int i = 0; i < n; i++) arr[i] /= maximumElement;
    }
}
