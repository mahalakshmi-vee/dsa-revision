class Solution {
    // Time Complexity: O(C with base N) 
    // C with base N represents the catalan number.
    // Space Complexity: O(C with base N)
    public List<String> generateParenthesis(int n) {
        List<String> listParenthesis = new ArrayList<>();
        backtrack (listParenthesis, n, 0, 0, new StringBuilder());
        return listParenthesis;
    }
    private void backtrack (List<String> listParenthesis, int n, int open, int close, StringBuilder sb) {
        if (sb.length() == 2 * n) {
            listParenthesis.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            backtrack(listParenthesis, n, open + 1, close, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(")");
            backtrack(listParenthesis, n, open, close + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}

// Time complexity analysis:
// c with base n (represents catalan series) =
// c with base 0 * c with base n - 1 +
// c with base 1 * c with base n - 2 +
// c with base 2 * c with base n - 3 + ......
// c with base n - 1 * c with base 0.

// n = 2 => 2 valid parentheses set can be formed
// ( 0 ) 1
// ( 1 ) 0

// n = 3 => 2 + 2 + 1 = 5 valid parentheses set can be formed
// ( 0 ) 2 
// ( 2 ) 0
// ( 1 ) 1
