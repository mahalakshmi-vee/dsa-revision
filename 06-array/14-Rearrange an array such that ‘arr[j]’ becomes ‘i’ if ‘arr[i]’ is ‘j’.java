
// Brute force approach:
// Time complexity is O(N)
// Space Complexity is O(N)
// class Main {
//     public static void main(String[] args) {
//         int[] input = {2, 0, 1, 4, 5, 3};
        // arr[1] = 0;
        // arr[3] = 1;
        // arr[0] = 2;
        // arr[2] = 3
        // output array should have {2, 0, 3, 1}

//         int n = input.length;
//         int[] resultantArray = new int[n];
//         for (int i = 0; i < n; i++) {
//             resultantArray[input[i]] = i;
//         }
        
//         for (int i = 0; i < n; i++) {
//             input[i] = resultantArray[i];
//         }
        
//         System.out.println("Printing the results:");
//         for (int i = 0; i < n; i++) {
//             System.out.println(input[i]);
//         }
//     }
// }


// Optimized approach: Using modulo arithmetic operations.
// Time complexity is O(N)
// Space Complexity is O(1)
class Main {
    public static void main(String[] args) {
        int[] input = {2, 0, 1, 4, 5, 3};
        // arr[1] = 0;
        // arr[3] = 1;
        // arr[0] = 2;
        // arr[2] = 3
        // output array should have {2, 0, 3, 1}

        int n = input.length;

        for (int i = 0; i < n; i++) {
            input[input[i] % n] += (i * n);
        }   
         
        for (int i = 0; i < n; i++) {
            input[i] = input[i] / n;
        }
         
        System.out.println("Printing the results:");
        for (int i = 0; i < n; i++) {
            System.out.println(input[i]);
        }
    }
}

