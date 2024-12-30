class Solution
{
   
    String reverseEqn(String S)
    {
        int n = S.length();
        StringBuilder answerSB = new StringBuilder();
        int ascii = 0;
        int startIndex = -1;
        int endIndex = n;
        for (int i = n - 1; i >= 0; i--) {
            ascii = S.charAt(i);
            if (ascii >= 48 && ascii <= 57) {
                startIndex = i;
            }
            else {
                answerSB.append(S.substring(startIndex, endIndex));
                answerSB.append(S.charAt(i));
                endIndex = i;
            }
        }
        answerSB.append(S.substring(startIndex, endIndex));
        return answerSB.toString();
    }
}