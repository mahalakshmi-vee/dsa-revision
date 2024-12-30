class Solution {
    public int countPrimes(int n) {
        boolean[] primeArr = new boolean[n];
        for (int i = 0; i < primeArr.length; i++) primeArr[i] = true;
        for (int i = 2; i * i < n; i++) {
            if (!primeArr[i]) continue;
            for (int j = 2; j * i < n; j++) {
                primeArr[j * i] = false;
            }
        }
        int primeCount = 0;
        for (int i = 2; i < primeArr.length; i++) {
            if (primeArr[i]) primeCount++;
        }
        return primeCount;
    }
}