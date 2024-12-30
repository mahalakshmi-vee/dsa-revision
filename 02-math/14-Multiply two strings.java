class Solution
{
    public String multiplyStrings(String s1,String s2)
    {
        if (s1.length() < s2.length()) return multiplyStrings(s2, s1);
        
        boolean addMinusToAnswer = s1.charAt(0) == '-' || s2.charAt(0) == '-';
        if (s1.charAt(0) == '-' && s2.charAt(0) == '-') addMinusToAnswer = false;
        
        s1 = s1.replaceAll("^0", "");
        s2 = s2.replaceAll("^0", "");
        
        int[] answerArr = new int[s1.length() + s2.length()];
        int num1 = 0;
        int num2 = 0;
        int index = answerArr.length - 1;
        int subIndex = 0;
        
        for (int i = s2.length() - 1; i >= 0; i--) {
            if (s2.charAt(i) == '-') continue;
            num1 = Character.getNumericValue(s2.charAt(i));
            subIndex = index;
            for (int j = s1.length() - 1; j >= 0; j--) {
                if (s1.charAt(j) == '-') continue;
                num2 = Character.getNumericValue(s1.charAt(j));
                answerArr[subIndex--] += (num1 * num2);
            }
            index--;
        }
        int number = 0;
        for (int i = answerArr.length - 1; i >= 0; i--) {
            number = answerArr[i];
            if (number > 9) {
                answerArr[i] = number % 10;
                answerArr[i - 1] += (number / 10);
            }
        }
        StringBuilder answerSB = new StringBuilder();
        for (int i = answerArr.length - 1; i >= 0; i--) {
            number = answerArr[i];
            answerSB.append(number);
        }
        
        String subAnswer = answerSB.reverse().toString(); 
        index = 0;
        while (index < subAnswer.length()) {
            if (subAnswer.charAt(index) != '0') break;
            index++;
        }
        String answer = subAnswer.substring(index);
        
        if (answer.length() == 0) return "0";
        
        if (addMinusToAnswer) {
            return "-"+answer;
        }
        
        return answer;
    }
}