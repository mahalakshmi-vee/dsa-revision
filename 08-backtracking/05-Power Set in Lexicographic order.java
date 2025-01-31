import java.util.*;
class Main {
    public static void main(String[] args) {
        String input = "abc";
    		StringBuilder sb = new StringBuilder(input);	
    		List<String> listAnswer = new ArrayList<>();
    		backtrack(sb, 0, listAnswer, new StringBuilder());
    		Collections.sort(listAnswer); // Sorting to make the answer in lexicographical order.
    		for (String s : listAnswer) System.out.println(s);
    }
    private static void backtrack (StringBuilder inputSB, int index, List<String> listAnswer, StringBuilder subAnswerSB) {
    		if (index == inputSB.length()) {
    			listAnswer.add(subAnswerSB.toString());
    			return;
    		}
    		subAnswerSB.append(inputSB.charAt(index));
    		backtrack(inputSB, index + 1, listAnswer, subAnswerSB);
    		subAnswerSB.deleteCharAt(subAnswerSB.length() - 1);
    		backtrack(inputSB, index + 1, listAnswer, subAnswerSB); 
	}
}
// Time Complexity: O(N * (2 ^ N))
// Space Complexity: O(N * (2 ^ N)) for storing all the possible results.
