class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> listAnswer = new ArrayList<>();
        backtrack(listAnswer, s, 0, 0, new StringBuilder());
        return listAnswer;
    }
    private void backtrack (List<String> listAnswer, String s, int index, int dotCount, StringBuilder subAnswerSB) {
        if (dotCount > 3) return;
        else if (dotCount == 3) {
            String lastSegment = s.substring(index);
            if (!validateIP(lastSegment)) {
                return;
            }
            listAnswer.add(subAnswerSB.toString() + lastSegment);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int  i = index; i < s.length(); i++) {
            sb.append(s.charAt(i)); 
            if (!validateIP(sb.toString())) {
                return;
            }
            subAnswerSB.append(sb.toString());
            subAnswerSB.append(".");
            backtrack(listAnswer, s, i + 1, dotCount + 1, subAnswerSB);
            subAnswerSB.delete(subAnswerSB.length() - sb.length() - 1, subAnswerSB.length());
        }
    }
    private boolean validateIP(String s) {
        if (s.length() > 1) {
            if (s.charAt(0) == '0') return false;
            else if (s.length() > 3) return false;
            else if (Integer.valueOf(s) > 255) return false;
        }
        return s.length() != 0;
    }
}
