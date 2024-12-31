class Solution {
    static int largestPrimeFactor(int n) {
        // Find all the prime numbers which are less than or equal to n.
        // Brute force approach: Got TLE.
        // boolean[] primeArr = new boolean[n + 1];
        // for (int i = 0; i < primeArr.length; i++) primeArr[i] = true;
        // for (int i = 2; i * i <= n; i++) {
        //     if (!primeArr[i]) continue;
        //     for (int j = 2; j * i <= n; j++) {
        //         primeArr[i * j] = false;
        //     }
        // }
        // List<Integer> listPrimeNumber = new ArrayList<>();
        // for (int i = 2; i < primeArr.length; i++) {
        //     if (primeArr[i]) listPrimeNumber.add(i);
        // }
        // int input = n;
        // int answer = 0;
        // int index = 0;
        // while (input > 1) {
        //     if (input % listPrimeNumber.get(index) != 0) index++;
        //     if (n % listPrimeNumber.get(index) != 0) {
        //         index++;
        //         continue;
        //     }
        //     answer = Math.max(answer, listPrimeNumber.get(index));
        //     input /= listPrimeNumber.get(index);
        // }
        // return answer;
        // Optimized approach: O(SQRT(N)) is the time complexity and O(1) is the space complexity.
        int answer = 0;
        int factor1 = 0;
        int factor2 = 0;
        for (int i = 1; i * i <= n; i++) {
            factor1 = i;
            factor2 = n / i;
            if (n % factor1 == 0 && isPrime(factor1)) answer = Math.max(answer, factor1);
            if (n % factor2 == 00 && isPrime(factor2)) answer = Math.max(answer, factor2);
        }
        return answer;
    }
    private static boolean isPrime (int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}