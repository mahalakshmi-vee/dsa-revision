class Solution {
    class Pair implements Comparable<Pair> {
        private char character;
        private int frequency;
        public Pair (char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        } 
        public char getCharacter() {

            return this.character;
        }
        public int getFrequency() {
            
            return this.frequency;
        }
        @Override
        public int compareTo (Pair pair) {

            return pair.frequency - this.frequency;
        }
    }
    // Time complexity is O(NLogN) and space complexity is O(N) (used in in-built sorting functions).
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) frequencyMap.put(s.charAt(i), frequencyMap.getOrDefault(s.charAt(i), 0) + 1);
        List<Pair> listElement = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) listElement.add(new Pair(entry.getKey(), entry.getValue()));
        Collections.sort(listElement);
        StringBuilder answerSB = new StringBuilder();
        for (Pair element : listElement) {
            char key = element.getCharacter();
            int frequency = element.getFrequency();
            while (frequency > 0) {
                answerSB.append(key);
                frequency--;
            }
        }
        return answerSB.toString();
    }
}
