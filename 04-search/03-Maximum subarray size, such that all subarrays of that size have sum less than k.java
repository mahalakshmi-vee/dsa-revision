import java.io.*;

class GFG {
 public static int func(int arr[], int k, int n)
 	{
		/* Brute force approach: Time complexity is O(N ^ 2) and space complexity is O(1).
		int answer = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = 0;
			for (int j = i; j < n; j++) {
				sum += arr[j];
				if (sum < k) answer = Math.max(answer, j - i + 1);
			}
		}		
		return answer;
		*/
		int start = 0;
		int end = 0;
		int sum = 0;
		int answer = 0;
		while (end < n) {
			sum += arr[end];
			while (sum > k) {
				sum -= arr[start];
				start++;
			}
			answer = Math.max(answer, end - start + 1);
			end++;
		}
		return answer;
	}
}

