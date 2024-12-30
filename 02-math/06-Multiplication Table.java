class Solution{
    static ArrayList<Integer> getTable(int N){
        ArrayList<Integer> listAnswer = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            listAnswer.add(N * i);
        }
        return listAnswer;
    }
}