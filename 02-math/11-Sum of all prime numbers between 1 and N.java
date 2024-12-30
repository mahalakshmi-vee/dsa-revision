class Solution
{
    public long prime_Sum(int n)
    {
        // Sive's Eratesthenis Algorithm for finding all the prime numbers between 1 to n.
        boolean[] primeArr = new boolean[n + 1];
        for (int i = 0; i <primeArr.length; i++) {
            primeArr[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (!primeArr[i]) continue;
            for (int j = 2; j * i <= n; j++) {
                primeArr[i * j] = false;
            }
        }
        long primeNumsSum = 0;
        for (int i = 2; i < primeArr.length; i++) {
            if (primeArr[i]) primeNumsSum += i;
        }
        return primeNumsSum;
    }
}