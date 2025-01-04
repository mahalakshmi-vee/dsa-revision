class Solution {
    public String reverseWords(String s) {
        // Time complexity is O(N) and space complexity is O(N), where N is the length of the input string.
        List<String> listWord = getListWord(s);
        int left = 0;
        int right = listWord.size() - 1;
        while (left < right) {
            String tempStr = listWord.get(left);
            listWord.set(left, listWord.get(right));
            listWord.set(right, tempStr);
            left++;
            right--;
        }
        StringBuilder answerSb = new StringBuilder();
        for (int i = 0; i < listWord.size(); i++) {
            answerSb.append(listWord.get(i));
            if (i != listWord.size() - 1) answerSb.append(" ");
        }
        return answerSb.toString();
    }
    private List<String> getListWord (String s) {
        List<String> listWord = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int ascii = 0;
        for (int i = 0; i < s.length(); i++) {
            ascii = s.charAt(i);
            if (ascii == 32) {
                if (sb.length() > 0) {
                    listWord.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
            else sb.append(s.charAt(i));
        }
        if (sb.length() > 0)
            listWord.add(sb.toString());
        return listWord;
    }
}
