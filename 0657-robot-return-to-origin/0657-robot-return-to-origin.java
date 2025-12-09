class Solution {
    public boolean judgeCircle(String moves) {
        char [] ch = moves.toCharArray();
        int countL = 0;
        int countR = 0;
        int countU = 0;
        int countD = 0;
        for(int i = 0; i<moves.length(); i++){
            if(ch[i] == 'L')countL++;
            if(ch[i] == 'R')countR++;
            if(ch[i] == 'U')countU++;
            if(ch[i] == 'D')countD++;

        }
        return countL == countR && countU == countD;
    }
}