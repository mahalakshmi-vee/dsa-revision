// Time Complexity: O(N)
// Space Complexity: O(N)
class GFG {
	static class Node {
		int data;
		Node next;
		public Node (int data)	{
			this.data = data;
			this.next = null;
		}
	}
	
	static Boolean check_pair_sum(Node head, int sum) {
		if (head == null || head.next == null) return false;
		Set<Integer> hashSet = new HashSet<>();
		Node current = head;
		while (current != null) {
			int neededValue = sum - current.data;
			if (hashSet.contains(neededValue)) return true;
			hashSet.add(current.data);
			current = current.next;
		}
		return false;
	}
}
