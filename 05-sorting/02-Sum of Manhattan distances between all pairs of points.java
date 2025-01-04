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
/* Note: Formula derivation to calculate the pair of distances sum in a single iteration for future reference.
                0   1   2   3   4   5   6
Suppose we have x1, x2, x3, x4, x5, x6, x7 x-coordinates when x1 <= x2 <= x3 <= x4 <= x5 <= x6 <= x7
Let i = 5
The task is to calculate the pair of distance sum from x6 to all the previous points
(x6 - x1) + (x6 - x2) + (x6 - x3) + (x6 - x4) + (x6 - x5)
4 * x6 - (x1 + x2 + x3 + x4 + x5) is the equation to calculate the pair of distance sum in a single iteration.
Formula: i * xi - Sum of all previous values of xi.
*/
