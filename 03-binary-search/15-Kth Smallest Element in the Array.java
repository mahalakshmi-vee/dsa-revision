public class Solution {
    public int kthsmallest(final List<Integer> A, int k) {
        int low = Integer.MAX_VALUE;
		int high = Integer.MIN_VALUE;
		int middle = 0;
		for (int i = 0; i < A.size(); i++) {
			low = Math.min(low, A.get(i));
			high = Math.max(high, A.get(i));
		}
		
		int countLess = 0;
		int countEqual = 0;
		int answer = Integer.MIN_VALUE;
		
		while (low <= high) {
			middle = (low + high) / 2;
			countEqual = 0;
			countLess = 0;
			for (int i = 0; i < A.size(); i++) {
				if (A.get(i) < middle) countLess++;
				else if (A.get(i) == middle) countEqual++;
                if (countLess >= k) break;
			}
			if (countLess < k && countLess + countEqual >= k) {
				answer = middle;
				break;
			}
			else if (countLess + countEqual >= k) high = middle - 1;
			else if (countLess + countEqual <= k) low = middle + 1;
		}
    
        return answer;
    }
}
// Time complexity: O(N Log(Max - Min))
// Space complexity: O(1)