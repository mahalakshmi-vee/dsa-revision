// import java.util.*;

// class Main {
    // Brute force approach:
    // Time Complexity: Catalan series C with base n.
    // C with base n = C with base 0 * C with base n - 1 + 
    //                 C with base 1 * C with base n - 2 + ......
    //                 C with base n - 1 * C with base 0.
    // Space Complexity: n * (C with base n).
    // Maximum number of methods in the stack at any point in time is n.
    // Space to store all the valid parentheses string is n * (C with base n).
//     public static void main(String[] args) {
//         int n = 8;
//         if (n % 2 == 0) {
//             List<String> listValidParentheses = new ArrayList<>();
//             getValidParenthesesList(n / 2, listValidParentheses, 0, 0, new StringBuilder());
//             System.out.println("Total number of valid parentheses is: "+listValidParentheses.size());
//             System.out.println("The valid parentheses are as follows: ");
//             for (String p : listValidParentheses) {
//                 System.out.println(p);
//             }
//         }
//     }
    
//     private static void getValidParenthesesList(int n, List<String> listValidParentheses, int open, int close, StringBuilder sb) {
//         if (sb.length() == 2 * n) {
//             listValidParentheses.add(sb.toString());
//             return;
//         }
        
//         if (open < n) {
//             sb.append("(");
//             getValidParenthesesList(n, listValidParentheses, open + 1, close, sb);
//             sb.deleteCharAt(sb.length() - 1);
//         }
//         if (close < open) {
//             sb.append(")");
//             getValidParenthesesList(n, listValidParentheses, open, close + 1, sb);
//             sb.deleteCharAt(sb.length() - 1);
//         }
//     }
// }

// Explanation:
// Let n = 1 => ()
// Let n = 2 => 
//             ( 0 ) 1 => () ()  (means put 0 valid paratheses inside and 2 outside)
//             ( 1 ) 0 => ( () )
// Let n = 3 =>
//             ( 0 ) 2 => () ()(), () ( () )
//             ( 1 ) 1 => ( () ) ()
//             ( 2 ) 0 => ( ()() ), ( ( () ))
            
