import java.io.*;
 
class GFG {
 
    // Return the sum of distance between all
    // the pair of points.
    // Brute force approach: Time complexity is O(N ^ 2) and space complexity is O(1).
    /*
    static int distancesum(int x[], int y[], int n)
    {
	int sum = 0;
	for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++) {
			sum += ((ath.abs(x[i] - x[j]) + (Math.abs(y[i] - y[j]));
		}
	}
	return sum;
    }
    */
    // Efficient approach: Time complexity is O(NLogN) and space complexity is O(N).
    static int distancesum(int x[], int y[], int n)
    {
	int xCoordinateSum = getDistancesum(x, n);
        int yCoordinateSum = getDistancesum(y, n);
	return xCoordinateSum + yCoordinateSum;
    }
    static int getDistancesum (int[] x, int n) {
    	Arrays.sort(x);
	int answer = 0;
	int sum = 0;
	for (int i = 0; i < n; i++) {
		answer += (i * x[i] - sum);
		sum += x[i];
	}
	return answer;
    }
}

