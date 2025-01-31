class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> listAnswer = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (findTotalSetbits(i) + findTotalSetbits(j) == turnedOn) {
                    String hours = String.valueOf(i);
                    String minutes = String.valueOf(j < 10 ? ("0" + j) : j);
                    listAnswer.add(hours+":"+minutes);
                }
            }
        }    
        return listAnswer;
    }
    private int findTotalSetbits (int number) {
        int totalSetBits = 0;
        for (int i = 0; i < 32; i++) {
            if ( (number & (1 << i)) != 0) totalSetBits++;
        }
        return totalSetBits;
    }
}
// Time and Space Complexity is:
// Time Complexity: O(1)
// Space Complexity: O(1)
